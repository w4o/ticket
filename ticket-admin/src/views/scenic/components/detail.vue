<template>
  <el-card class="form-container" shadow="never">
    <el-form ref="scenicInfoForm" :model="scenic" :rules="rules" label-width="120px" style="width: 600px" size="small">
      <el-form-item label="景点分类：" prop="categoryId">
        <el-cascader
          :options="scenicCateOptions"
          :props="{ 'value': 'id' }"
          filterable
          @change="handleCategoryChange"
        />
      </el-form-item>
      <el-form-item label="景点名称：" prop="name">
        <el-input v-model="scenic.name" />
      </el-form-item>
      <el-form-item label="景点简称：" prop="shortName">
        <el-input v-model="scenic.shortName" />
      </el-form-item>
      <el-form-item label="景点卖点：">
        <el-input v-model="scenic.sellPoint" />
      </el-form-item>
      <el-form-item label="开放时间：">
        <el-input v-model="scenic.openTime" />
      </el-form-item>
      <el-form-item label="景点地址：">
        <el-input v-model="scenic.address" />
      </el-form-item>
      <el-form-item label="景点图片">
        <el-upload
          :action="uploadPath"
          :show-file-list="false"
          :headers="headers"
          :on-success="uploadPicUrl"
          class="avatar-uploader"
          accept=".jpg,.jpeg,.png,.gif"
        >
          <img v-if="scenic.picUrl" :src="scenic.picUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon" />
        </el-upload>
      </el-form-item>
      <el-form-item label="景点相册：">
        <el-upload
          :action="uploadPath"
          :limit="5"
          :headers="headers"
          :on-exceed="uploadOverrun"
          :on-success="handlePhotoUrl"
          :on-remove="handlePhotoRemove"
          multiple
          accept=".jpg,.jpeg,.png,.gif"
          list-type="picture-card"
        >
          <i class="el-icon-plus" />
        </el-upload>
      </el-form-item>
      <el-form-item label="景点须知：">
        <tinymce v-model="scenic.notice" :init="tinymceInit" />
      </el-form-item>

      <el-form-item label="景点介绍：">
        <tinymce v-model="scenic.description" :init="tinymceInit" />
      </el-form-item>
      <el-form-item style="text-align: center">
        <el-button type="primary" size="medium" @click="handleCreate">创建景点</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>
<script>
import { getOptionsWithChildren } from '@/api/scenicCategory'
import { createScenic, getScenic, updateScenic } from '@/api/scenic'
import Tinymce from '@tinymce/tinymce-vue'
import { getToken } from '@/utils/auth'
import { createStorage, uploadPath } from '@/api/storage'

export default {
  components: { Tinymce },
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      uploadPath,
      active: 0,
      showStatus: [true, false, false, false],
      scenic: {
        categoryId: 0,
        name: '',
        shortName: '',
        sellPoint: '',
        openTime: '',
        address: '',
        picUrl: '',
        photo: [],
        notice: '',
        description: ''
      },
      scenicCateOptions: [],
      rules: {
        name: [
          { required: true, message: '请输入景点名称', trigger: 'blur' },
          { min: 2, max: 140, message: '长度在 2 到 140 个字符', trigger: 'blur' }
        ],
        shortName: [{ required: true, message: '请输入景点简称', trigger: 'blur' }],
        categoryId: [{ required: true, message: '请选择景点分类', trigger: 'blur' }],
        description: [{ required: true, message: '请输入景点介绍', trigger: 'blur' }]
      },
      tinymceInit: {
        language: 'zh_CN',
        convert_urls: false,
        images_upload_handler: function(blobInfo, success, failure) {
          const formData = new FormData()
          formData.append('file', blobInfo.blob())
          createStorage(formData).then(res => {
            success(res.data.data.url)
          }).catch(() => {
            failure('上传失败，请重新上传')
          })
        }
      }
    }
  },
  computed: {
    headers() {
      return {
        'X-Ticket-Admin-Token': getToken()
      }
    }
  },
  created() {
    if (this.isEdit) {
      getScenic(this.$route.query.id).then(response => {
        this.productParam = response.data
      })
    }
    this.getScenicCateList()
  },
  methods: {
    hideAll() {
      for (let i = 0; i < this.showStatus.length; i++) {
        this.showStatus[i] = false
      }
    },
    uploadPicUrl: function(response) {
      console.log(response)
      if (response.code === 0) {
        this.scenic.picUrl = response.data.url
      } else {
        this.$notify.error({
          title: '失败',
          message: response.message
        })
      }
    },
    uploadOverrun: function() {
      this.$message({
        type: 'error',
        message: '上传文件个数超出限制!最多上传5张图片!'
      })
    },
    handlePhotoUrl(response, file, fileList) {
      if (response.code === 0) {
        this.scenic.photo.push(response.data.url)
      } else {
        this.$notify.error({
          title: '失败',
          message: response.message
        })
      }
    },
    handlePhotoRemove: function(file, fileList) {
      for (let i = 0; i < this.scenic.photo.length; i++) {
        // 这里存在两种情况
        // 1. 如果所删除图片是刚刚上传的图片，那么图片地址是file.response.data.url
        //    此时的file.url虽然存在，但是是本机地址，而不是远程地址。
        // 2. 如果所删除图片是后台返回的已有图片，那么图片地址是file.url
        let url
        if (file.response === undefined) {
          url = file.url
        } else {
          url = file.response.data.url
        }

        if (this.goods.gallery[i] === url) {
          this.goods.gallery.splice(i, 1)
        }
      }
    },
    getScenicCateList() {
      getOptionsWithChildren().then(response => {
        this.scenicCateOptions = response.data.list
      })
    },
    handleCategoryChange(value) {
      this.scenic.categoryId = value[value.length - 1]
    },
    handleCreate() {
      this.$refs['scenicInfoForm'].validate(valid => {
        if (valid) {
          this.$confirm('是否要提交该景点？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            if (this.isEdit) {
              updateScenic(this.$route.query.id, this.scenic).then(response => {
                if (response.code === 0) {
                  this.$message({
                    type: 'success',
                    message: '提交成功',
                    duration: 1000
                  })
                } else {
                  this.$notify.error({
                    title: '失败',
                    message: response.message
                  })
                }
              })
            } else {
              createScenic(this.scenic).then(response => {
                if (response.code === 0) {
                  this.$message({
                    type: 'success',
                    message: '提交成功',
                    duration: 1000
                  })
                } else {
                  this.$notify.error({
                    title: '失败',
                    message: response.message
                  })
                }
              })
            }
          })
        } else {
          this.$notify.error({
            title: '失败',
            message: '信息填写完整'
          })
        }
      })
    }
  }
}
</script>
<style>
  .form-container {
    width: 800px;
  }
  .avatar-uploader .el-upload {
   border: 1px dashed #d9d9d9;
   border-radius: 6px;
   cursor: pointer;
   position: relative;
   overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>

