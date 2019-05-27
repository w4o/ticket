<template>
  <el-card class="form-container" shadow="never">
    <el-form
      ref="categoryForm"
      :model="category"
      :rules="rules"
      label-width="150px"
    >
      <el-form-item label="分类名称：" prop="name">
        <el-input v-model="category.name" />
      </el-form-item>
      <el-form-item label="上级分类：">
        <el-select
          v-model="category.parentId"
          value="0"
          placeholder="请选择分类"
        >
          <el-option
            v-for="item in categoryOptions"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="排序：">
        <el-input v-model="category.sort" />
      </el-form-item>
      <el-form-item label="是否显示：">
        <el-radio-group v-model="category.showStatus">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否显示在导航栏：">
        <el-radio-group v-model="category.navStatus">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="分类图标：">
        <el-upload
          :headers="headers"
          :action="uploadPath"
          :show-file-list="false"
          :on-success="uploadAvatar"
          class="icon-uploader"
          accept=".jpg,.jpeg,.png,.gif"
        >
          <img v-if="category.icon" :src="category.icon" class="icon" alt="icon">
          <i v-else class="el-icon-plus icon-uploader-icon" />
        </el-upload>
      </el-form-item>
      <el-form-item label="分类描述：">
        <el-input v-model="category.description" type="textarea" rows="3" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="createDate">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>
<style>
  .icon-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .icon-uploader .el-upload:hover {
    border-color: #20a0ff;
  }
  .icon-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 48px;
    height: 48px;
    line-height: 48px;
    text-align: center;
  }
  .icon {
    width: 45px;
    height: 45px;
    display: block;
  }
</style>
<script>
import { getToken } from '@/utils/auth'
import { getOptions, createCategory, updateCategory } from '@/api/scenicCategory'

export default {
  filters: {
    filterLabelFilter(index) {
      if (index === 0) {
        return '筛选属性：'
      } else {
        return ''
      }
    }
  },
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      categoryOptions: [],
      uploadPath: '/admin/upload',
      category: {
        description: '',
        icon: '',
        keywords: '',
        name: '',
        navStatus: 0,
        parentId: 0,
        productUnit: '',
        showStatus: 0,
        sort: 0
      },
      rules: {
        name: [
          { required: true, message: '请输入分类名称', trigger: 'blur' },
          { min: 2, max: 140, message: '长度在 2 到 140 个字符', trigger: 'blur' }
        ]
      },
      filterAttrs: [],
      filterProductAttrList: [{
        value: []
      }]
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
    this.getCategoryOptions()
  },
  methods: {
    uploadAvatar() { },
    getCategoryOptions() {
      getOptions().then(response => {
        this.categoryOptions = response.data.list
        this.categoryOptions.unshift({ id: 0, name: '无上级分类' })
      })
    },
    resetForm() {
      this.category = {
        description: '',
        icon: '',
        keywords: '',
        name: '',
        navStatus: 0,
        parentId: 0,
        productUnit: '',
        showStatus: 0,
        sort: 0
      }
    },
    createDate() {
      this.$refs['categoryForm'].validate(valid => {
        if (valid) {
          this.$confirm('是否提交数据？', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            if (this.isEdit) {
              updateCategory(this.$route.query.id, this.category).then(() => {
                this.$notify.success({
                  title: '成功',
                  message: '修改商品分类成功'
                })
                this.$router.back()
              }).catch(response => {
                this.$notify.error({
                  title: '失败',
                  message: response.message
                })
              })
            } else {
              createCategory(this.category).then(() => {
                this.$notify.success({
                  title: '成功',
                  message: '添加商品分类成功'
                })
                this.$router.back()
              }).catch(response => {
                this.$notify.error({
                  title: '失败',
                  message: response.message
                })
              })
            }
          }).catch()
        }
      })
    }
  }
}
</script>
