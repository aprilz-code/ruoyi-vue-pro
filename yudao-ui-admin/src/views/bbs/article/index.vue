<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="文章标题" prop="title">
        <el-input v-model="queryParams.title" placeholder="请输入文章标题" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否原创" prop="isOriginal">
        <el-select v-model="queryParams.isOriginal" placeholder="请选择是否原创" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.BOOLEAN_STATUS)"
                     :key="dict.value" :label="dict.label" :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="文章分类ID" prop="classifyId">
        <el-input v-model="queryParams.classifyId" placeholder="请输入文章分类ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否置顶" prop="isTop">
        <el-select v-model="queryParams.isTop" placeholder="请选择是否置顶" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.BOOLEAN_STATUS)"
                     :key="dict.value" :label="dict.label" :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类型" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.BBS_ARTICLE_TYPE)"
                     :key="dict.value" :label="dict.label" :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.COMMON_STATUS)"
                     :key="dict.value" :label="dict.label" :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['bbs:article:create']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
                   :loading="exportLoading"
                   v-hasPermi="['bbs:article:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="id" align="center" prop="id"/>
      <el-table-column label="标题图" align="center" prop="thumb" width="160" fixed>
        <template slot-scope="scope">
          <img
            v-if="scope.row.thumb"
            :src="scope.row.thumb"
            style="width: 130px;height: 70px;"
          >
        </template>
      </el-table-column>
      <el-table-column label="文章标题" align="center" prop="title"/>

      <el-table-column label="推荐等级" align="center" prop="level" width="100px">
        <template v-slot="scope">
          <el-rate v-model="scope.row.level" :max="3" :colors="['#99A9BF', '#F7BA2A', '#FF9900']"
                   :low-threshold="1" :high-threshold="3" :disabled="true"
          />
        </template>
      </el-table-column>

      <el-table-column label="类型" align="center" prop="type">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.BBS_ARTICLE_TYPE" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="文章分类UID" align="center" prop="classifyId"/>
      <el-table-column label="标签" align="center" prop="tagIds"  width="200px">
        <template v-slot="scope">
          <template>
            <el-tag
              style="margin-left: 3px"
              type="warning"
              v-if="item"
              :key="index"
              v-for="(item, index) in scope.row.tagNames"
            >{{item}}</el-tag>
          </template>
        </template>
      </el-table-column>

      <el-table-column label="作者" align="center" prop="author"/>
      <el-table-column label="是否原创" align="center" prop="isOriginal">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.BOOLEAN_STATUS" :value="scope.row.isOriginal"/>
        </template>
      </el-table-column>
      <el-table-column label="文章点击数" align="center" prop="clickCount"/>
      <el-table-column label="文章收藏数" align="center" prop="collectCount"/>
      <el-table-column label="文章分享数" align="center" prop="shareCount"/>

      <el-table-column label="是否置顶" align="center" prop="isTop">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.BOOLEAN_STATUS" :value="scope.row.isTop"/>
        </template>
      </el-table-column>

      <el-table-column label="开启评论" align="center" prop="openComment">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.COMMON_STATUS" :value="scope.row.openComment"/>
        </template>
      </el-table-column>

      <el-table-column label="状态" align="center" prop="status">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.COMMON_STATUS" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['bbs:article:update']"
          >修改
          </el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['bbs:article:delete']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="80%" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="文章标题" prop="title">
              <el-input v-model="form.title" placeholder="请输入文章标题"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="标题缩略图地址">
              <imageUpload v-model="form.thumb" :limit="1"/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="是否置顶" prop="isTop">
              <el-select v-model="form.isTop" placeholder="请选择是否置顶">
                <el-option v-for="dict in this.getDictDatas(DICT_TYPE.BOOLEAN_STATUS)"
                           :key="dict.value" :label="dict.label" :value="parseInt(dict.value)"
                />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>


        <el-row>
          <el-col :span="24">
            <el-form-item label="文章简介" prop="summary">
              <el-input type="textarea" :rows="3" v-model="form.summary" placeholder="请输入文章简介"/>
            </el-form-item>
          </el-col>
        </el-row>


        <el-row>
          <el-col :span="12">
            <el-form-item label="标签" prop="tagIds">
              <el-select
                @input="contentChange"
                v-model="form.tagIds"
                multiple
                size="small"
                placeholder="请选择"
                style="width:210px"
                filterable
              >
                <el-option
                  v-for="item in tagList"
                  :key="item.id"
                  :label="item.content"
                  :value="item.id"
                ></el-option>
              </el-select>

            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="文章分类" prop="classifyId">
              <el-input v-model="form.classifyId" placeholder="请输入文章分类UID"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>

          <el-col :span="12">
            <el-form-item label="推荐等级" prop="level">
              <el-rate v-model="form.level" :max="3"
                       :colors="['#99A9BF', '#F7BA2A', '#FF9900']"
                       :low-threshold="1" :high-threshold="3"
                       show-text
                       :texts="['正常', '推荐', '超级推荐']"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="作者" prop="author">
              <el-input v-model="form.author" placeholder="请输入作者"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="是否原创" prop="isOriginal">
              <el-select v-model="form.isOriginal" placeholder="请选择是否原创">
                <el-option v-for="dict in this.getDictDatas(DICT_TYPE.BOOLEAN_STATUS)"
                           :key="dict.value" :label="dict.label" :value="parseInt(dict.value)"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="文章出处" v-show="form.isOriginal == 0" :rules="form.isOriginal == 0 ? rules.articlesPart : []" prop="articlesPart">
              <el-input v-model="form.articlesPart" placeholder="请输入文章出处"/>
            </el-form-item>
          </el-col>

        </el-row>

        <el-row>

          <el-col :span="12">
            <el-form-item label="类型" prop="type">
              <el-radio-group v-model="form.type">
                <el-radio v-for="dict in this.getDictDatas(DICT_TYPE.BBS_ARTICLE_TYPE)"
                          :key="dict.value" :label="dict.value"
                >{{ dict.label }}
                </el-radio>
              </el-radio-group>
              (推广，则外链必填)
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="外链" prop="outsideLink" v-show="form.type == '1'" :rules="form.type == '1'? rules.outsideLink : []">
              <el-input v-model="form.outsideLink" placeholder="请输入外链"/>
            </el-form-item>
          </el-col>
        </el-row>


        <el-row>
          <el-col :span="12">
            <el-form-item label="开启评论" prop="openComment">
              <el-select v-model="form.openComment" placeholder="请选择开启评论">
                <el-option v-for="dict in this.getDictDatas(DICT_TYPE.COMMON_STATUS)"
                           :key="dict.value" :label="dict.label" :value="parseInt(dict.value)"
                />
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择状态">
                <el-option v-for="dict in this.getDictDatas(DICT_TYPE.COMMON_STATUS)"
                           :key="dict.value" :label="dict.label" :value="parseInt(dict.value)"
                />
              </el-select>
            </el-form-item>
          </el-col>

        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="文章内容" prop="content">
              <markdown-editor ref="markdownEditor" v-model="form.content" height="500px"/>
            </el-form-item>
          </el-col>
        </el-row>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    createArticle,
    deleteArticle,
    exportArticleExcel,
    getArticle,
    getArticlePage,
    updateArticle
  } from '@/api/bbs/article'
  import ImageUpload from '@/components/ImageUpload'
  import MarkdownEditor from '@/components/MarkdownEditor'
  import { getTagPage } from '@/api/bbs/tag'

  export default {
    name: 'Article',
    components: {
      ImageUpload,
      MarkdownEditor
    },
    data() {
      return {
        // 遮罩层
        loading: true,
        // 导出遮罩层
        exportLoading: false,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 文章列表
        list: [],
        tagList: [],
        tagSize: 0,
        // 弹出层标题
        title: '',
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNo: 1,
          pageSize: 10,
          title: null,
          thumb: null,
          summary: null,
          content: null,
          tagIds: null,
          isOriginal: null,
          articlesPart: null,
          classifyId: null,
          isTop: null,
          level: null,
          openComment: null,
          type: null,
          status: null,
          createTime: []
        },
        // 表单参数
        form: {
          id: undefined,
          title: undefined,
          thumb: undefined,
          summary: undefined,
          content: undefined,
          tagIds: [],
          isOriginal: 1,
          author: undefined,
          articlesPart: undefined,
          classifyId: undefined,
          isTop: 0,
          level: 1,
          openComment: 1,
          type: '0',
          outsideLink: undefined,
          status: 0
        },
        // 表单校验
        rules: {
          title: [{ required: true, message: '文章标题不能为空', trigger: 'blur' }],
          content: [{ required: true, message: '文章内容不能为空', trigger: 'blur' }],
          tagIds: [{ required: true, message: '标签ids不能为空', trigger: 'blur' }],
          isOriginal: [{ required: true, message: '是否原创（0:不是 1：是）不能为空', trigger: 'blur' }],
          author: [{ required: true, message: '作者不能为空', trigger: 'blur' }],
          classifyId: [{ required: true, message: '文章分类UID不能为空', trigger: 'blur' }],
          isTop: [{ required: true, message: '是否置顶（0不是 1是）不能为空', trigger: 'blur' }],
          openComment: [{ required: true, message: '开启评论不能为空', trigger: 'blur' }],
          type: [{ required: true, message: '类型不能为空', trigger: 'blur' }],
          status: [{ required: true, message: '状态不能为空', trigger: 'change' }],
          outsideLink: [{ required: true, message: '外链不能为空', trigger: 'blur' }],
          articlesPart: [{ required: true, message: '文章出处不能为空', trigger: 'blur' }],

        }
      }
    },
    created() {
      this.getList()
      this.getTags()
    },
    methods: {
      /** 查询列表 */
      getList() {
        this.loading = true
        // 执行查询
        getArticlePage(this.queryParams).then(response => {
          this.list = response.data.list
          this.total = response.data.total
          this.loading = false
        })
      },
      contentChange() {
        console.log(this.form.tagIds)
      },
      getTags() {
        // 执行查询
        let tagParams = {}
        tagParams.pageSize = 500
        tagParams.pageNo = 1
        getTagPage(this.tagParams).then(response => {
          this.tagList = response.data.list
          this.tagSize = response.data.total
        })
      },
      /** 取消按钮 */
      cancel() {
        this.open = false
        this.reset()
      },
      /** 表单重置 */
      reset() {
        this.resetForm('form')

      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNo = 1
        this.getList()
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm('queryForm')
        this.handleQuery()
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset()
        this.open = true
        this.title = '添加文章'
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset()
        const id = row.id
        getArticle(id).then(response => {
          this.form = response.data
          this.open = true
          this.title = '修改文章'
        })
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs['form'].validate(valid => {
          if (!valid) {
            return
          }
          //this.form.tagIds = this.form.tagIds.join(",");
          // 修改的提交
          if (this.form.id != null) {
            updateArticle(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
            return
          }
          // 添加的提交
          createArticle(this.form).then(response => {
            this.$modal.msgSuccess('新增成功')
            this.open = false
            this.getList()
          })
        })
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const id = row.id
        this.$modal.confirm('是否确认删除文章编号为"' + id + '"的数据项?').then(function() {
          return deleteArticle(id)
        }).then(() => {
          this.getList()
          this.$modal.msgSuccess('删除成功')
        }).catch(() => {
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        // 处理查询参数
        let params = { ...this.queryParams }
        params.pageNo = undefined
        params.pageSize = undefined
        this.$modal.confirm('是否确认导出所有文章数据项?').then(() => {
          this.exportLoading = true
          return exportArticleExcel(params)
        }).then(response => {
          this.$download.excel(response, '文章.xls')
          this.exportLoading = false
        }).catch(() => {
        })
      }
    }
  }
</script>
