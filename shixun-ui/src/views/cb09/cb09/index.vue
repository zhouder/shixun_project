<template>
  <div class="app-container">
<!--    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">-->
    <el-form :model="queryParams"  ref="queryForm" size="small" :inline="true" v-show="showSearch" >
      <el-form-item label="检测单位名称" style="margin-left: -50px;" prop="testOrgName" label-width="150px" class="wide-space">
        <el-input
          v-model="queryParams.testOrgName"
          placeholder="请输入检测单位名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工程名称" style="margin-left: 30px;" prop="projectName" class="wide-space">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入工程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="margin-left: 20px;" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
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
          v-hasPermi="['cb09:cb09:add']"
        >新增</el-button>
      </el-col>
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['cb09:cb09:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          plain-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['cb09:cb09:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="warning"-->
<!--          plain-->
<!--          icon="el-icon-download"-->
<!--          size="mini"-->
<!--          @click="handleExport"-->
<!--          v-hasPermi="['cb09:cb09:export']"-->
<!--        >导出</el-button>-->
<!--      </el-col>-->
<!--      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>-->
    </el-row>

    <el-table v-loading="loading" :data="cb09List" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="${comment}" align="center" prop="id" />-->
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="检测单位名称" align="center" prop="testOrgName" />
      <el-table-column label="工程名称" align="center" prop="projectName" />
      <el-table-column label="结论" align="center" prop="result" />
      <el-table-column label="生成日期" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改日期" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['cb09:cb09:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-plus"
            @click="handleAdd"
            v-hasPermi="['cb09:cb09:add']"
          >增加</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['cb09:cb09:remove']"
          >删除</el-button>
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

    <!-- 添加或修改硬化后水泥混凝土性能试验检测报告对话框 -->
<!--    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>-->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
<!--      <el-form ref="form" :model="form" :rules="rules" label-width="80px">-->
      <el-form ref="form" :model="form" :rules="rules" label-width="150px" size="mini">
        <el-row>
          <el-col span="12">
            <el-form-item label="检测单位名称" prop="testOrgName">
              <el-input v-model="form.testOrgName" placeholder="请输入检测单位名称" />
            </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="报告编号" prop="reportNo">
<!--              <el-input v-model="form.reportNo" placeholder="请输入报告编号" />-->
              <el-input v-model="form.reportNo" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col span="12">
            <el-form-item label="工程名称" prop="projectName">
              <el-input v-model="form.projectName" placeholder="请输入工程名称" />
            </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="合同段" prop="contractArea">
              <el-input v-model="form.contractArea"  />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col span="12">
            <el-form-item label="施工单位" prop="constructionOrgName">
              <el-input v-model="form.constructionOrgName" />
            </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="监理单位" prop="supervisorOrgName">
              <el-input v-model="form.supervisorOrgName"  />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="工程部位/用途" prop="projectPartAndPurpose">
          <el-input v-model="form.projectPartAndPurpose"  />
        </el-form-item>
        <el-form-item label="样品信息" prop="sampleInfo">
          <el-input v-model="form.sampleInfo"  />
        </el-form-item>
        <el-row>
          <el-col span="12">
            <el-form-item label="检测依据" prop="testingBasis">
            <el-input v-model="form.testingBasis" placeholder="请输入内容" />
          </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="判定依据" prop="judgmentCriteria">
              <el-input v-model="form.judgmentCriteria" placeholder="请输入内容" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="主要仪器设备名称和编号" prop="equipmentNameAndNo" >
          <el-input v-model="form.equipmentNameAndNo" maxlength="200"  />
        </el-form-item>
        <el-row style="margin-top:-18px;">
          <el-col span="12">
            <el-form-item label="配合比编号" prop="mixProportionNo">
              <el-input v-model="form.mixProportionNo"  />
            </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="设计抗渗等级" prop="impermeabilityLevel">
              <el-input v-model="form.impermeabilityLevel"  />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col span="12">
            <el-form-item label="设计强度(MPa)" prop="designStrength">
              <el-input v-model="form.designStrength" placeholder="" />
            </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="搅拌方式" prop="stirType">
              <el-input v-model="form.stirType" placeholder="" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col span="12">
            <el-form-item label="成型日期" prop="formingDate">
              <el-date-picker clearable
                              v-model="form.formingDate"
                              type="date"
                              value-format="yyyy-MM-dd"
                              placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="坍落度" prop="slumpsValue">
              <el-input-number
                v-model="form.slumpsValue"
                :precision="2"
                :step="0.1">
              </el-input-number>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col span="12">
            <el-form-item label="养护方式" prop="maintainType">
              <el-input v-model="form.maintainType" placeholder="" />
            </el-form-item>
          </el-col>
          <el-col span="12">
            <el-form-item label="龄期(d)" prop="ageValue" >
              <el-input-number
                v-model="form.ageValue"
                :precision="0"
                :step="1">
              </el-input-number>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row >
          <el-col :span="5" style="margin-left: 50px;">
            <b><span>试验日期</span></b>
          </el-col>
          <el-col :span="2">
            <b><span>组号</span></b>
          </el-col>
          <el-col :span="5">
            <b><span>检测停止时的水压力(MPa)</span></b>
          </el-col>
          <el-col :span="6">
            <b><span>检测停止时的渗水试件的数量（个）</span></b>
          </el-col>
          <el-col :span="4">
            <b><span>实测抗渗等级</span></b>
          </el-col>
        </el-row>
        <el-row style="margin-top:5px;">
          <el-col :span="5" style="margin-left: 50px;">
              <el-date-picker clearable
                              v-model="form.testDate"
                              type="date"
                              value-format="yyyy-MM-dd"
                              placeholder="选择日期">
              </el-date-picker>
          </el-col>
          <el-col :span="2">
              <el-input v-model="form.teamNo" placeholder="" maxlength="20"/>
          </el-col>
          <el-col :span="5" >
              <el-input-number style="width: 150px;"
                v-model="form.testStopWaterPressure"
                :precision="2"
                :step="0.1">
              </el-input-number>
          </el-col>
          <el-col :span="6">
              <el-input-number style="width: 150px;"
                v-model="form.testStopSeepagePartNum"
                :precision="0"
                :step="1">
              </el-input-number>
          </el-col>
          <el-col :span="4">
              <el-input v-model="form.testStrength" placeholder="" maxlength="200"/>
          </el-col>
        </el-row>
        <el-row style="margin-top: 20px;">
          <el-col :span="24">
            <el-form-item label="结论" prop="result">
              <el-input v-model="form.result" type="textarea" placeholder="" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="附加声明" prop="additionalStatement">
              <el-input v-model="form.additionalStatement" type="textarea" placeholder="" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col span="6">
            <el-form-item label="检测" style="margin-left: 50px" prop="testPerson" label-width="100px">
              <el-input v-model="form.testPerson" placeholder="" />
            </el-form-item>
          </el-col>
          <el-col span="5">
            <el-form-item label="审核" prop="examinePerson" label-width="100px">
              <el-input v-model="form.examinePerson" placeholder="" />
            </el-form-item>
          </el-col>
          <el-col span="5">
            <el-form-item label="批准" prop="approvePerson" label-width="100px">
              <el-input v-model="form.approvePerson" placeholder="" />
            </el-form-item>
          </el-col>
          <el-col span="8">
            <el-form-item label="日期" prop="reportDate" label-width="100px">
              <el-date-picker clearable
                              v-model="form.reportDate"
                              type="date"
                              value-format="yyyy-MM-dd"
                              placeholder="选择日期">
              </el-date-picker>
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
import { listCb09, getCb09, delCb09, addCb09, updateCb09 } from "@/api/cb09/cb09";

export default {
  name: "Cb09",
  data() {
    return {
      ageValue:null,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 硬化后水泥混凝土性能试验检测报告表格数据
      cb09List: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        testOrgName: null,
        projectName: null,
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
    /** 查询硬化后水泥混凝土性能试验检测报告列表 */
    getList() {
      this.loading = true;
      listCb09(this.queryParams).then(response => {
        this.cb09List = response.rows;
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
        testOrgName: null,
        reportNo: null,
        projectName: null,
        contractArea: null,
        constructionOrgName: null,
        supervisorOrgName: null,
        projectPartAndPurpose: null,
        sampleInfo: null,
        testingBasis: null,
        judgmentCriteria: null,
        equipmentNameAndNo: null,
        mixProportionNo: null,
        impermeabilityLevel: null,
        designStrength: null,
        stirType: null,
        formingDate: null,
        slumpsValue: null,
        maintainType: null,
        ageValue: null,
        testDate: null,
        teamNo: null,
        testStopWaterPressure: null,
        testStopSeepagePartNum: null,
        testStrength: null,
        result: null,
        additionalStatement: null,
        testPerson: null,
        examinePerson: null,
        approvePerson: null,
        reportDate: null,
        createTime: null,
        updateTime: null
      };
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
      this.title = "添加硬化后水泥混凝土性能试验检测报告";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCb09(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改硬化后水泥混凝土性能试验检测报告";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCb09(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCb09(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除硬化后水泥混凝土性能试验检测报告编号为"' + ids + '"的数据项？').then(function() {
        return delCb09(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cb09/cb09/export', {
        ...this.queryParams
      }, `cb09_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style>
  .name-code {
    text-align: left !important; /* 使用 !important 确保覆盖默认样式 */
    white-space: normal; /* 允许换行 */
    overflow: visible; /* 确保内容不会溢出 */
  }
</style>
