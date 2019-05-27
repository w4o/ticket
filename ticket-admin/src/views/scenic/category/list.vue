<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.name" placeholder="景点分类名" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-edit" @click="handleCreate">添加</el-button>
    </div>

    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      row-key="id"
    >
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="分类名称">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="商品数量">
        <template slot-scope="scope">
          {{ scope.row.scenicCount }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="设置" />
      <el-table-column align="center" label="操作" />
    </el-table>

  </div>
</template>

<script>
import { getList } from '@/api/scenicCategory'
import waves from '@/directive/waves'

export default {
  directives: { waves },
  filters: {},
  data() {
    return {
      list: null,
      listLoading: true,
      listQuery: {
        name: undefined
      }
    }
  },
  computed: {},
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getList(this.listQuery).then(response => {
        this.list = response.data.list
        this.listLoading = false
      })
    },
    handleFilter() {
      this.fetchData()
    },
    handleCreate() {
      this.$router.push({ path: '/scenic/category/add' })
    }
  }
}
</script>
