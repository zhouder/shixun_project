<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="施工单位" prop="sgdw">
        <el-input
          v-model="queryParams.sgdw"
          placeholder="请输入施工单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="建造单位" prop="jzdw">
        <el-input
          v-model="queryParams.jzdw"
          placeholder="请输入建造单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="监理单位" prop="jldw">
        <el-input
          v-model="queryParams.jldw"
          placeholder="请输入监理单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工程名称" prop="gcmc">
        <el-input
          v-model="queryParams.gcmc"
          placeholder="请输入工程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同号" prop="hth">
        <el-input
          v-model="queryParams.hth"
          placeholder="请输入合同号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="编号" prop="bh">
        <el-input
          v-model="queryParams.bh"
          placeholder="请输入编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工程部位" prop="gcbw">
        <el-input
          v-model="queryParams.gcbw"
          placeholder="请输入工程部位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="杆件名称" prop="gjmc">
        <el-input
          v-model="queryParams.gjmc"
          placeholder="请输入杆件名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="杆件编号" prop="gjbh">
        <el-input
          v-model="queryParams.gjbh"
          placeholder="请输入杆件编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="焊接方法" prop="hjff">
        <el-input
          v-model="queryParams.hjff"
          placeholder="请输入焊接方法"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="接头形式" prop="jtxs">
        <el-input
          v-model="queryParams.jtxs"
          placeholder="请输入接头形式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="环境温度(℃)" prop="hjwd">
        <el-input
          v-model="queryParams.hjwd"
          placeholder="请输入环境温度(℃)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="相对湿度(%)" prop="xdsd">
        <el-input
          v-model="queryParams.xdsd"
          placeholder="请输入相对湿度(%)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="施工员" prop="sgy">
        <el-input
          v-model="queryParams.sgy"
          placeholder="请输入施工员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业工程师" prop="zygcs">
        <el-input
          v-model="queryParams.zygcs"
          placeholder="请输入专业工程师"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="cjsj">
        <el-date-picker clearable
          v-model="queryParams.cjsj"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['zbmain:zbmain:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['zbmain:zbmain:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['zbmain:zbmain:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['zbmain:zbmain:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="zbmainList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="施工单位" align="center" prop="sgdw" />
      <el-table-column label="建造单位" align="center" prop="jzdw" />
      <el-table-column label="监理单位" align="center" prop="jldw" />
      <el-table-column label="工程名称" align="center" prop="gcmc" />
      <el-table-column label="合同号" align="center" prop="hth" />
      <el-table-column label="编号" align="center" prop="bh" />
      <el-table-column label="工程部位" align="center" prop="gcbw" />
      <el-table-column label="杆件名称" align="center" prop="gjmc" />
      <el-table-column label="杆件编号" align="center" prop="gjbh" />
      <el-table-column label="焊接方法" align="center" prop="hjff" />
      <el-table-column label="接头形式" align="center" prop="jtxs" />
      <el-table-column label="环境温度(℃)" align="center" prop="hjwd" />
      <el-table-column label="相对湿度(%)" align="center" prop="xdsd" />
      <el-table-column label="施工员" align="center" prop="sgy" />
      <el-table-column label="专业工程师" align="center" prop="zygcs" />
      <el-table-column label="创建时间" align="center" prop="cjsj" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.cjsj, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['zbmain:zbmain:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['zbmain:zbmain:remove']"
          >删除</el-button>
          <el-button
            v-hasPermi="['zbmain:zbmain:export']"
            size="mini"
            type="text"
            @click="handleEasyExcel(scope.row)"
          >导出excel</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改主要焊缝施焊记录主表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <!-- 第一行：施工单位（单独一行） -->
        <el-form-item label="施工单位：" prop="sgdw">
          <el-input v-model="form.sgdw" placeholder="请输入施工单位" style="width: 370px;" />
        </el-form-item>

        <!-- 第二行：建造单位和合同号 -->
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="建造单位：" prop="jzdw">
              <el-input v-model="form.jzdw" placeholder="请输入建造单位" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合同号：" prop="hth">
              <el-input v-model="form.hth" placeholder="请输入合同号" />
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第三行：监理单位和编号 -->
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="监理单位：" prop="jldw">
              <el-input v-model="form.jldw" placeholder="请输入监理单位" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="编号：" prop="bh">
              <el-input v-model="form.bh" placeholder="请输入编号" />
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第四行：工程名称和工程部位 -->
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="工程名称：" prop="gcmc">
              <el-input v-model="form.gcmc" placeholder="请输入工程名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="工程部位：" prop="gcbw">
              <el-input v-model="form.gcbw" placeholder="请输入工程部位" />
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第五行：杆件名称、杆件编号、环境温度 -->
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="杆件名称：" prop="gjmc">
              <el-input v-model="form.gjmc" placeholder="请输入杆件名称" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="杆件编号：" prop="gjbh">
              <el-input v-model="form.gjbh" placeholder="请输入杆件编号" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="环境温度(℃)：" prop="hjwd">
              <el-input-number v-model="form.hjwd" :min="0" :max="50" placeholder="环境温度" style="width: 100%;" />
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第六行：焊接方法、接头形式、相对湿度 -->
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="焊接方法：" prop="hjff">
              <el-select v-model="form.hjff" placeholder="请选择焊接方法" style="width: 100%;">
                <el-option label="手工电弧焊" value="手工电弧焊"></el-option>
                <el-option label="埋弧焊" value="埋弧焊"></el-option>
                <el-option label="气体保护焊" value="气体保护焊"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="接头形式：" prop="jtxs">
              <el-select v-model="form.jtxs" placeholder="请选择接头形式" style="width: 100%;">
                <el-option label="对接接头" value="对接接头"></el-option>
                <el-option label="角接接头" value="角接接头"></el-option>
                <el-option label="T型接头" value="T型接头"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="相对湿度(%)：" prop="xdsd">
              <el-input-number v-model="form.xdsd" :min="0" :max="100" placeholder="相对湿度" style="width: 100%;" />
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第七行：施工员和专业工程师 -->
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="施工员：" prop="sgy">
              <el-input v-model="form.sgy" placeholder="请输入施工员" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="专业工程师：" prop="zygcs">
              <el-input v-model="form.zygcs" placeholder="请输入专业工程师" />
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第八行：创建时间 -->
        <el-form-item label="创建时间：" prop="cjsj" >
          <el-date-picker
            v-model="form.cjsj"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择创建时间"
            style="width: 370px;" />
        </el-form-item>
        <el-divider content-position="center">主要焊缝施焊记录子表信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddSj40Detail">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteSj40Detail">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="sj40DetailList" :row-class-name="rowSj40DetailIndex" @selection-change="handleSj40DetailSelectionChange" ref="sj40Detail">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="焊缝编号" prop="hfbh" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.hfbh" placeholder="请输入焊缝编号" />
            </template>
          </el-table-column>
          <el-table-column label="焊道序号" prop="hdxh" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.hdxh" placeholder="请输入焊道序号" />
            </template>
          </el-table-column>
          <el-table-column label="预热温度(℃)" prop="yrwd" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.yrwd" placeholder="请输入预热温度(℃)" />
            </template>
          </el-table-column>
          <el-table-column label="层间温度(℃)" prop="cjwd" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.cjwd" placeholder="请输入层间温度(℃)" />
            </template>
          </el-table-column>
          <el-table-column label="焊接材料" prop="hjcl" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.hjcl" placeholder="请输入焊接材料" />
            </template>
          </el-table-column>
          <el-table-column label="电流(A)" prop="dl" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.dl" placeholder="请输入电流(A)" />
            </template>
          </el-table-column>
          <el-table-column label="电压(V)" prop="dy" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.dy" placeholder="请输入电压(V)" />
            </template>
          </el-table-column>
          <el-table-column label="车速(m/h)" prop="cs" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.cs" placeholder="请输入车速(m/h)" />
            </template>
          </el-table-column>
          <el-table-column label="焊工编号" prop="hgbh" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.hgbh" placeholder="请输入焊工编号" />
            </template>
          </el-table-column>
          <el-table-column label="操作时间" prop="czsj" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.czsj" type="date" value-format="yyyy-MM-dd" placeholder="请选择操作时间" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listZbmain, getZbmain, delZbmain, addZbmain, updateZbmain, exportEasyExcel } from "@/api/zbmain/zbmain";

export default {
  name: "Zbmain",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedSj40Detail: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 主要焊缝施焊记录主表表格数据
      zbmainList: [],
      // 主要焊缝施焊记录子表表格数据
      sj40DetailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sgdw: null,
        jzdw: null,
        jldw: null,
        gcmc: null,
        hth: null,
        bh: null,
        gcbw: null,
        gjmc: null,
        gjbh: null,
        hjff: null,
        jtxs: null,
        hjwd: null,
        xdsd: null,
        sgy: null,
        zygcs: null,
        cjsj: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询主要焊缝施焊记录主表列表 */
    getList() {
      this.loading = true;
      listZbmain(this.queryParams).then(response => {
        this.zbmainList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        sgdw: null,
        jzdw: null,
        jldw: null,
        gcmc: null,
        hth: null,
        bh: null,
        gcbw: null,
        gjmc: null,
        gjbh: null,
        hjff: null,
        jtxs: null,
        hjwd: null,
        xdsd: null,
        sgy: null,
        zygcs: null,
        cjsj: null
      };
      this.sj40DetailList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加主要焊缝施焊记录主表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getZbmain(id).then(response => {
        this.form = response.data;
        this.sj40DetailList = response.data.sj40DetailList;
        this.open = true;
        this.title = "修改主要焊缝施焊记录主表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.sj40DetailList = this.sj40DetailList;
          if (this.form.id != null) {
            updateZbmain(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addZbmain(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除主要焊缝施焊记录主表编号为"' + ids + '"的数据项？').then(function() {
        return delZbmain(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },

    handleEasyExcel(row) {
      console.log(row)
      exportEasyExcel(row.id).then(response =>{
        this.$modal.msgSuccess("导出成功");
      });
    },

	/** 主要焊缝施焊记录子表序号 */
    rowSj40DetailIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 主要焊缝施焊记录子表添加按钮操作 */
    handleAddSj40Detail() {
      let obj = {};
      obj.hfbh = "";
      obj.hdxh = "";
      obj.yrwd = "";
      obj.cjwd = "";
      obj.hjcl = "";
      obj.dl = "";
      obj.dy = "";
      obj.cs = "";
      obj.hgbh = "";
      obj.czsj = "";
      this.sj40DetailList.push(obj);
    },
    /** 主要焊缝施焊记录子表删除按钮操作 */
    handleDeleteSj40Detail() {
      if (this.checkedSj40Detail.length == 0) {
        this.$modal.msgError("请先选择要删除的主要焊缝施焊记录子表数据");
      } else {
        const sj40DetailList = this.sj40DetailList;
        const checkedSj40Detail = this.checkedSj40Detail;
        this.sj40DetailList = sj40DetailList.filter(function(item) {
          return checkedSj40Detail.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleSj40DetailSelectionChange(selection) {
      this.checkedSj40Detail = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('zbmain/zbmain/export', {
        ...this.queryParams
      }, `zbmain_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
