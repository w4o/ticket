<template>
  <div style="margin-top: 50px">
    <el-form ref="productInfoForm" :model="value" :rules="rules" label-width="120px" style="width: 600px" size="small">
      <el-form-item label="商品分类：" prop="productCategoryId">
        <el-cascader
          v-model="value.productCategoryId"
          :options="productCateOptions"
          :props="{ 'value': 'id' }"
          filterable
        />
      </el-form-item>
      <el-form-item label="商品名称：" prop="name">
        <el-input v-model="value.name" />
      </el-form-item>
      <el-form-item label="副标题：" prop="subTitle">
        <el-input v-model="value.subTitle" />
      </el-form-item>
      <el-form-item label="商品介绍：">
        <el-input
          v-model="value.description"
          :auto-size="true"
          type="textarea"
          placeholder="请输入内容"
        />
      </el-form-item>
      <el-form-item label="商品货号：">
        <el-input v-model="value.productSn" />
      </el-form-item>
      <el-form-item label="商品售价：">
        <el-input v-model="value.price" />
      </el-form-item>
      <el-form-item label="市场价：">
        <el-input v-model="value.originalPrice" />
      </el-form-item>
      <el-form-item label="商品库存：">
        <el-input v-model="value.stock" />
      </el-form-item>
      <el-form-item label="计量单位：">
        <el-input v-model="value.unit" />
      </el-form-item>
      <el-form-item label="排序">
        <el-input v-model="value.sort" />
      </el-form-item>
      <el-form-item style="text-align: center">
        <el-button type="primary" size="medium" @click="handleNext('productInfoForm')">下一步，填写商品促销</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { getOptionsWithChildren } from '@/api/productCategory'

export default {
  props: {
    value: {
      name: String
    },
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      hasEditCreated: false,
      // 选中商品分类的值
      selectProductCateValue: [],
      productCateOptions: [],
      brandOptions: [],
      rules: {
        name: [
          { required: true, message: '请输入商品名称', trigger: 'blur' },
          { min: 2, max: 140, message: '长度在 2 到 140 个字符', trigger: 'blur' }
        ],
        subTitle: [{ required: true, message: '请输入商品副标题', trigger: 'blur' }],
        productCategoryId: [{ required: true, type: 'array', message: '请选择商品分类', trigger: 'blur' }],
        description: [{ required: true, message: '请输入商品介绍', trigger: 'blur' }],
        requiredProp: [{ required: true, message: '该项为必填项', trigger: 'blur' }]
      }
    }
  },
  computed: {
    // 商品的编号
    productId() {
      return this.value.id
    }
  },
  watch: {
    productId(newValue) {
      if (!this.isEdit) { return }
      if (this.hasEditCreated) { return }
      if (newValue === undefined || newValue === null || newValue === 0) { return }
      this.handleEditCreated()
    },
    selectProductCateValue(newValue) {
      if (newValue != null && newValue.length === 2) {
        this.value.productCategoryId = newValue[1]
        this.value.productCategoryName = this.getCateNameById(this.value.productCategoryId)
      } else {
        this.value.productCategoryId = null
        this.value.productCategoryName = null
      }
    }
  },
  created() {
    this.getProductCateList()
  },
  methods: {
    // 处理编辑逻辑
    handleEditCreated() {
      if (this.value.productCategoryId != null) {
        this.selectProductCateValue.push(this.value.cateParentId)
        this.selectProductCateValue.push(this.value.productCategoryId)
      }
      this.hasEditCreated = true
    },
    getProductCateList() {
      getOptionsWithChildren().then(response => {
        this.productCateOptions = response.data.list
      })
    },
    getCateNameById(id) {
      let name = null
      for (let i = 0; i < this.productCateOptions.length; i++) {
        for (let j = 0; i < this.productCateOptions[i].children.length; j++) {
          if (this.productCateOptions[i].children[j].value === id) {
            name = this.productCateOptions[i].children[j].label
            return name
          }
        }
      }
      return name
    },
    handleNext(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$emit('nextStep')
        } else {
          this.$message({
            message: '验证失败',
            type: 'error',
            duration: 1000
          })
          return false
        }
      })
    },
    handleBrandChange(val) {
      let brandName = ''
      for (let i = 0; i < this.brandOptions.length; i++) {
        if (this.brandOptions[i].value === val) {
          brandName = this.brandOptions[i].label
          break
        }
      }
      this.value.brandName = brandName
    }
  }
}
</script>
