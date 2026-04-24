package com.highershine.gdna2.constants;

import java.util.ArrayList;
import java.util.List;

public class SysConfigConstant {
	
    //页面显示的系统配置项
	/** 系统基本配置 */
	public final static String SYS_BASIC_CONFIG = "SYS_BASIC_CONFIG";	
	/** 系统开关配置 */
	public final static String SYSTEM_FLAG_CONFIG = "SYSTEM_FLAG_CONFIG";
	/**DNALIMS接口开关*/
	public final static String RECEIVE_DNALIMS_SWITCH = "RECEIVE_DNALIMS_SWITCH";
	/**现勘接口开关*/
	public final static String RECEIVE_SCENE_SWITCH = "RECEIVE_SCENE_SWITCH";
	/**综采接口开关*/
	public final static String RECEIVE_COLLECT_SWITCH = "RECEIVE_COLLECT_SWITCH";
	/**综合实验室接口开关*/
	public final static String RECEIVE_LAB_SWITCH = "RECEIVE_LAB_SWITCH";
	/**除DNALIMS、现勘、综采、综合实验室外接口开关*/
	public final static String RECEIVE_OTHER_SWITCH = "RECEIVE_OTHER_SWITCH";
	/**校验token开关*/
	public final static String VERIFY_TOKEN_SWITCH = "VERIFY_TOKEN_SWITCH";

	/**定时同步国家库一级的数据库版本开关*/
	public final static String SYNC_GDNA_VERSION_SWITCH = "SYNC_GDNA_VERSION_SWITCH";

	public static final String SWITCH_OPEN = "1";
	public static final String SWITCH_CLOSE = "0";

	/** 污染比对条件设置 */
    public static final String POLLUTION_COMPARE_SETTING = "POLLUTION_AUTO_COMPARE_SETTING";
	/** 服务器监控配置-MIS服务器监控 */
	public final static String SERVER_MONITOR_CONFIG_MIS = "SERVER_MONITOR_CONFIG_MIS";
	/** 服务器监控配置-DIS服务器监控 */
	public final static String SERVER_MONITOR_CONFIG_DIS = "SERVER_MONITOR_CONFIG_DIS";
	/** 文书生成类型 */
	public final static String REPORT_GENERATE_TYPE = "REPORT_GENERATE_TYPE";
	/** 文件保存根目录 */
	public static final String FILE_SAVE_PATH = "FILE_SAVE_PATH_CONFIG";	
	/** 分析工具接口配置 */
	public static final String LRVALUE_CONFIG = "LRVALUE_CONFIG";
	/** 授权验证请求配置   */
	public static final String EMPOWER_CONFIG = "EMPOWER_CONFIG";

	/**
	 * 验权接口请求配置
	 */
	public static final String AUTHENTICATION_CONFIG = "AUTHENTICATION_CONFIG";
	/** 扫描二维码录入分型功能开关配置   */
	public static final String SCAN_QR_CODE_SWITCH_CONFIG = "SCAN_QR_CODE_SWITCH_CONFIG";
	/** 国家库查重配置 */
	public static final String NATION_CHECK_REPEAT_CONFIG = "NATION_CHECK_REPEAT_CONFIG";
	/** PKI配置 */
	public static final String PKI_CONFIG = "PKI_CONFIG";
	/** 登录配置-是否只使用pki 登录 */
	public static final String PKI_ONLY = "PKI_ONLY";
	public static final String PKI_ONLY_YES = "1";
	public static final String PKI_ONLY_NO = "0";
	
	
	public static final String PKI_CONFIG_XJ = "XJ_PKI_CONFIG";
	
	/** 系统备份路径配置 */
	public static final String BACKUP_CONFIG = "BACKUP_CONFIG";
	/** 关联系统地址配置 */
	public final static String EXTERNAL_SYS_URL = "EXTERNAL_SYS_URL";
	/** 统一登录配置*/
	public final static String UNIFIED_LOGIN_CONFIG = "UNIFIED_LOGIN_CONFIG";
	/** 单一样本分析配置*/
	public final static String SINGLE_ANALYSIS_CONFIG = "SINGLE_SAMPLE_ANALYSIS";
	/** 自动判定人人比中无容差通报配置*/
	public final static String JUDGE_PERSON_PERSON_NOTIFICATION = "JUDGE_PERSON_PERSON_NOTIFICATION";
	/** Y2.0 数据库配置 */
	public final static String YSTR2_DATABASE_SET = "YSTR2_DATABASE_SET";
	/** pki 登录配置 */
	public final static String PKI_LOGIN_CONFIG = "PKI_LOGIN_CONFIG";
	
	//特殊设置的系统配置项
	/** 编号规则--国家库配置 */
	public static final String SN_NATIONAL_CONFIG = "SN_NATIONAL_CONFIG";
	/** 编号规则--自定义配置 */
	public static final String SN_SELF_CONFIG = "SN_SELF_CONFIG";
	/** 编号规则--补送案件委托编号配置 */
	public static final String TYPE_APPEND_CASE_CONSIGN_NO = "TYPE_APPEND_CASE_CONSIGN_NO";
	/** 编号规则--补送身份不明人员委托编号配置 */
	public static final String TYPE_APPEND_UNKNOWN_PERSON_CONSIGN_NO = "TYPE_APPEND_UNKNOWN_PERSON_CONSIGN_NO";
	/** 编号规则--补送失踪人口委托编号规则 */
	public static final String TYPE_APPEND_MISSING_PERSON_CONSIGN_NO = "TYPE_APPEND_MISSING_PERSON_CONSIGN_NO";
	/** 编号规则--补送案件受理编号规则*/
	public static final String TYPE_APPEND_CASE_ACCEPT_NO = "TYPE_APPEND_CASE_ACCEPT_NO";
	/** 编号规则--补送身份不明人员受理编号规则*/
	public static final String TYPE_APPEND_UNKNOWN_PERSON_ACCEPT_NO = "TYPE_APPEND_UNKNOWN_PERSON_ACCEPT_NO";
	/** 编号规则--补送失踪人口受理编号规则*/
	public static final String TYPE_APPEND_MISSING_PERSON_ACCEPT_NO = "TYPE_APPEND_MISSING_PERSON_ACCEPT_NO";
	
	/** 关联系统类型 */
	public final static String EXTERNAL_SYS_TYPE = "EXTERNAL_SYS_TYPE";
	/** 实验室用户自动审核配置 */
	public final static String LABEMPLOYEE_AUDIT = "LABEMPLOYEE_AUDIT";
	//关联系统编外的外部名称与二期关联系统类型的对应
	public final static String EXTERNALSYS_NAME_TYPE  = "EXTERNALSYS_NAME_TYPE";
	
	/** 非FMQ数据传输配置 */
	public final static String NOT_FMQ_TRANSFER_DATA_CONFIG = "NOT_FMQ_TRANSFER_DATA_CONFIG";
	/** 非FMQ数据传输配置名称 */
	public final static String NOT_FMQ_TRANSFER_DATA_NAME = "数据传输限制";
	/** FMQ传输配置 */
	public final static String FMQ_TRANSFER_DATA_CONFIG = "FMQ_TRANSFER_DATA_CONFIG";
	
	//不显示的系统配置项
	/** 系统内部配置类型 */
	public final static String SYS_INNER_CONFIG = "SYS_INNER_CONFIG";
	
	/** dna3.6访问路径配置 */
	public final static String CATEGORY_DNA36_URL = "DNA36_URL";
	public final static String CONFIG_LOCAL_DNA36_URL = "LOCAL_DNA36_URL";
	
	
	//已不使用的系统配置项
	/** STR入库条件设置  */
	public static final String CATEGORY_STR_INSTORE_CONFIG = "INSTORE_CONFIG_STR";
	/** Y-STR入库条件设置  */
	public static final String CATEGORY_YSTR_INSTORE_CONFIG = "INSTORE_CONFIG_YSTR";
	
	/**
	 * FMQ往下传输时，需要更新本地数据的类别列表
	 */
	public static List<String> needUpdateSysConfigList = new ArrayList<String>();
	static {
		needUpdateSysConfigList.add(SN_NATIONAL_CONFIG);
	}
	
	
	////////////////////////////////////////////////////////////////////
	//以下为配置项的子名称常量
	///////////////////////////////////////////////////////////////////
	
	
	//系统配置项
	//
	/** 基因座个数 AUTO_COMPARE_SETTING */
	public static final String CONFIG_LOCUS_COUNT = "LOCUS_COUNT";
	/** 核心基因座个数  AUTO_COMPARE_SETTING*/
	public static final String CONFIG_CORE_LOCUS_COUNT = "CORE_LOCUS_COUNT";
	/** 自动比对设置-最大返回个数  AUTO_COMPARE_SETTING*/
	public static final String CS_MAX_RESULT_CNT = "MAX_RESULT_CNT";
	//同型
	/** 目标库范围   AUTO_COMPARE_SETTING*/
	public static final String SAME_TARGET_SCOPE = "SAME_TARGET_SCOPE";
	/** 匹配下限 AUTO_COMPARE_SETTING */
	public static final String SAME_LIMIT = "SAME_LIMIT";
	/** 容差上限 AUTO_COMPARE_SETTING  */
	public static final String SAME_DIFF_LIMIT = "SAME_DIFF_LIMIT";
	/** 数组格式存储核心基因座索引列表  AUTO_COMPARE_SETTING*/
	public static final String SAME_MAIN_LOCI = "SAME_MAIN_LOCI";
	//亲缘
	/** 目标库范围  AUTO_COMPARE_SETTING*/
	public static final String TRIPLETS_TARGET_SCOPE = "TRIPLETS_TARGET_SCOPE";
	/** 匹配下限 AUTO_COMPARE_SETTING */
	public static final String TRIPLETS_LIMIT = "TRIPLETS_LIMIT";
	/** 容差上限 AUTO_COMPARE_SETTING  */
	public static final String TRIPLETS_DIFF_LIMIT = "TRIPLETS_DIFF_LIMIT";
	/** 数组格式存储核心基因座索引列表  AUTO_COMPARE_SETTING*/
	public static final String TRIPLETS_MAIN_LOCI = "TRIPLETS_MAIN_LOCI";

	/**
	 * 文书配置
	 */
	//FILE_READ_PATH
	/** 文件上传保存目录  FILE_SAVE_PATH_CONFIG */
	public static final String PATH_FILE_UPLOAD = "PATH_FILE_UPLOAD";
	//委托书
	public static final String FILE_CONSIGN_WRITE_PATH = "CONSIGN_WRITE_PATH";
	//受理登记表
	public static final String FILE_ACCEPT_WRITE_PATH = "ACCEPT_WRITE_PATH"; 
	//鉴定书
	public static final String FILE_EXPERTISE_WRITE_PATH = "EXPERTISE_WRITE_PATH"; 
	//扩增记录目录
	public static final String FILE_AUGMENT_WRITE_PATH = "AUGMENT_WRITE_PATH"; 
	//电泳记录目录
	public static final String FILE_ELECTROPHORESIS_WRITE_PATH = "ELECTROPHORESIS_WRITE_PATH"; 
	//提取记录目录
	public static final String FILE_ABSTRACT_WRITE_PATH = "ABSTRACT_WRITE_PATH"; 
	//仪器附件上传目录
	public static final String FILE_ATTACHMENT_WRITE_PATH = "INSTRUMENT_FILE_UPLOAD_PATH"; 

	//文件格式选择  REPORT_GENERATE_TYPE
	public static final String FILETYPE_CONSIGN = "FILETYPE_CONSIGN";
	public static final String FILETYPE_ACCEPT = "FILETYPE_ACCEPT";
	public static final String FILETYPE_EXAM = "FILETYPE_EXAM";
	 
	//国家库查重开关 NATION_CHECK_REPEAT_CONFIG
	public static final String DO_NATION_FLAG = "DO_NATION_REPEAT_FLAG";
	public static final String NATION_REPEAT_REQUEST_URL = "NATION_REPEAT_REQUEST_URL";

	/** 似然比接口地址  LRVALUE_CONFIG */
	public static final String LRVALUE_URL = "LRVALUE_URL";

	/** 授权验证请求接口路径  EMPOWER_CONFIG */
	public static final String EMPOWER_URL = "EMPOWER_URL";
	/**
	 * 鉴权请求接口路径
	 */
	public static final String AUTHENTICATION_URL = "AUTHENTICATION_URL";

	/**
	 * token鉴权请求接口路径
	 */
	public static final String AUTHENTICATION_TOKEN_URL = "AUTHENTICATION_TOKEN_URL";

	/**
	 * token鉴权请求接口的AUTHENTICATION值
	 */
	public static final String AUTHENTICATION_TOKEN_VALUE = "AUTHENTICATION_TOKEN_VALUE";

	/** MIS服务器监控访问地址 SERVER_MONITOR_CONFIG_MIS */
	public final static String SERVER_MONITOR_MIS = "SERVER_MONITOR_MIS";
	/** DIS服务器监控访问地址 SERVER_MONITOR_CONFIG_DIS */
	public final static String SERVER_MONITOR_DIS = "SERVER_MONITOR_DIS";
	
	/** MIS项目发布名称<P>SYS_BASIC_CONFIG */
	public final static String APPNAME_MIS = "APPNAME_MIS";
	/** LIMS项目发布名称<p>SYS_BASIC_CONFIG */
	public final static String APPNAME_LIMS = "APPNAME_LIMS";
	
	//SYSTEM_FLAG_CONFIG系统开关配置子项
	/** 打开所有委托单位树节点 SYSTEM_FLAG_CONFIG */
	public final static String ALL_CONSIGN_ORG_FLAG = "ALL_CONSIGN_ORG_FLAG";
	/** dna3.6数据库设置 SYSTEM_FLAG_CONFIG */
	public final static String CHECK_DNA36_NOTIFICATION = "CHECK_DNA36_NOTIFICATION";
	/** 授权验证开关 */
	public final static String EMPOWER_CHECK_FLAG = "EMPOWER_CHECK_FLAG";

	public final static String AUTHENTICATION_CHECK_FLAG = "AUTHENTICATION_CHECK_FLAG";
	
	//统一登录配置，具体的配置项
	public final static String UNIFIED_LOGIN_CONFIG_KEY = "UNIFIED_LOGIN_CONFIG";
	//单一样本分析配置，具体的配置项
	public final static String SINGLE_SAMPLE_ANALYSIS_KEY = "SINGLE_SAMPLE_ANALYSIS";
	//自动判定人人比中无容差通报配置，具体的配置项
	public final static String JUDGE_PERSON_PERSON_NOTIFICATION_KEY = "JUDGE_PERSON_PERSON_NOTIFICATION";
	
	//系统模块权限配置常量 （JSON串调用）
	/** 字典 */
	public final static String AUTHORITY_SYSDICT = "sysDictManager";
	/** 配置表 */
	public final static String AUTHORITY_SYSCONFIG = "sysConfigManager";
	/** 服务器 */
	public final static String AUTHORITY_LABSERVER = "labServerManager";
	/** 委托单位 */
	public final static String AUTHORITY_CONSIGNORG = "consignOrgManager";
	/** 行政区划 */
	public final static String AUTHORITY_REGIONALISM = "sysRegionalismManager";
	/** 基因座 */
	public final static String AUTHORITY_LOCUSINFO = "locusInfoManager";
	/** 试剂盒  */
	public final static String AUTHORITY_REAGENTKIT = "reagentKitManager";
	/** 基因频率方案 */
	public final static String AUTHORITY_FREQUENCYSCHEME = "frequencySchemeManager";
	/** 数据必填验证 */
	public final static String AUTHORITY_DATAVERIFICATION = "dataVerificationManager";
	/** 标准对象 */
	public final static String AUTHORITY_STANDARDOBJECT = "standardObjectManager";
	
	//PKI设置
	/** PKI开关模式  <p>PKI_CONFIG */
	public final static String PKI_FLAG = "PKI_FLAG";
	/** 网关认证地址（pkiFlag=1时有效）  <p>PKI_CONFIG */
	public final static String PKI_AUTHURL = "PKI_AUTHURL";
	/** APPID（pkiFlag=1时有效）  <p>PKI_CONFIG */
	public final static String PKI_APPID = "PKI_APPID";

	public final static String PKI_AUTH_PARAM = "PKI_AUTH_PARAM";
	
	//FMQ设置	
	/** FMQ根路径 <p>FMQ_TRANSFER_DATA_CONFIG */
	public final static String FMQ_ROOT_DIR = "FMQ_ROOT_DIR";
	/** FMQ发送目录 <p>FMQ_TRANSFER_DATA_CONFIG */
	public final static String FMQ_SEND_DIR = "FMQ_SEND_DIR";
	/** FMQ发送历史目录 <p>FMQ_TRANSFER_DATA_CONFIG */
	public final static String FMQ_SEND_HISTORY_DIR = "FMQ_SEND_HISTORY_DIR";
	/** FMQ接收目录 <p>FMQ_TRANSFER_DATA_CONFIG */
	public final static String FMQ_REC_DIR = "FMQ_REC_DIR";
	/** FMQ接收历史目录 <p>FMQ_TRANSFER_DATA_CONFIG */
	public final static String FMQ_REC_HISTORY_DIR = "FMQ_REC_HISTORY_DIR";
	
	
	//BACKUP_CONFIG
	/** 备份文件路径  <p>BACKUP_CONFIG*/
	public final static String BACKUP_BACK_FILEPATH = "BACKUP_BACK_FILEPATH";
	/** 还原文件路径  <p>BACKUP_CONFIG*/
	public final static String BACKUP_RESOTRE_FILEPATH = "BACKUP_RESOTRE_FILEPATH";
	/** 自动备份设置文件路径  <p>BACKUP_CONFIG*/
	public final static String BACKUP_SETTING_FILEPATH = "BACKUP_SETTING_FILEPATH";
	
	/**现勘地址**/
	public final static String EXTERNAL_URL_XCKC = "EXTERNAL_URL_XCKC";
	
	//现勘系统
	public final static String EXTERNAL_XK = "1";
	//警综系统
	public final static String EXTERNAL_JZ = "2";
	//警情系统
	public final static String EXTERNAL_JQ = "3";
	//邢专系统
	public final static String EXTERNAL_XZ = "4";
	//无名尸系统
	public final static String EXTERNAL_WMS = "5";
	
	public final static String OPEN_FLAG_TRUE = "1";
	public final static String OPEN_FLAG_FALSE = "0";
	
	public final static String UNIFIED_LOGIN_CONFIG_VALUE_YES = "1";
	
	/**旧系统转换得到的DNA信息发送优先级*/
	public static final String OLD_DNA_INFO_TRANSFER = "OLD_DNA_INFO_TRANSFER";
	/**旧系统转换得到的DNA信息接收优先级*/
	public static final String OLD_DNA_INFO_RECEIVE = "OLD_DNA_INFO_RECEIVE";
	/**新系统录入的DNA信息发送优先级*/
	public static final String NEW_DNA_INFO_TRANSFER = "NEW_DNA_INFO_TRANSFER";
	/**新系统录入的DNA信息接收优先级*/
	public static final String NEW_DNA_INFO_RECEIVE = "NEW_DNA_INFO_RECEIVE";
	/**通报信息发送的优先级*/
	public static final String NOTIFICATION_TRANSFER = "NOTIFICATION_TRANSFER";
	/**通报信息接收的优先级*/
	public static final String NOTIFICATION_RECEIVE = "NOTIFICATION_RECEIVE";
	/**手工比对请求发送的优先级*/
	public static final String MANUAL_COMPARE_REQUEST_TRANSFER = "MANUAL_COMPARE_REQUEST_TRANSFER";
	/**手工比对请求接收的优先级*/
	public static final String MANUAL_COMPARE_REQUEST_RECEIVE = "MANUAL_COMPARE_REQUEST_RECEIVE";
	/**手工比对结果发送的优先级*/
	public static final String MANUAL_COMPARE_RESULT_TRANSFER = "MANUAL_COMPARE_RESULT_TRANSFER";
	/**手工比对结果接收的优先级*/
	public static final String MANUAL_COMPARE_RESULT_RECEIVE = "MANUAL_COMPARE_RESULT_RECEIVE";
	/**实验室人员信息发送的优先级*/
	public static final String LAB_EMPLOYEE_TRANSFER = "LAB_EMPLOYEE_TRANSFER";
	/**实验室人员信息接收的优先级*/
	public static final String LAB_EMPLOYEE_RECEIVE = "LAB_EMPLOYEE_RECEIVE";
	/**实验室通讯消息发送的优先级*/
	public static final String LAB_MESSAGE_TRANSFER = "LAB_MESSAGE_TRANSFER";
	/**实验室通讯消息接收的优先级*/
	public static final String LAB_MESSAGE_RECEIVE = "LAB_MESSAGE_RECEIVE";
	/**质控人员信息发送的优先级*/
	public static final String QC_PERSON_TRANSFER = "QC_PERSON_TRANSFER";
	/**质控人员信息接收的优先级*/
	public static final String QC_PERSON_RECEIVE = "QC_PERSON_RECEIVE";
	/**接收数据反馈发送的优先级*/
	public static final String RESPONSE_MESSAGE_TRANSFER = "RESPONSE_MESSAGE_TRANSFER";
	/**接收数据反馈接收的优先级*/
	public static final String RESPONSE_MESSAGE_RECEIVE = "RESPONSE_MESSAGE_RECEIVE";
	/**字典信息发送的优先级*/
	public static final String DICT_INFO_TRANSFER = "DICT_INFO_TRANSFER";
	/**字典信息接收的优先级*/
	public static final String DICT_INFO_RECEIVE = "DICT_INFO_RECEIVE";
	/**实验室信息发送的优先级*/
	public static final String LAB_INFO_TRANSFER = "LAB_INFO_TRANSFER";
	/**实验室信息接收的优先级*/
	public static final String LAB_INFO_RECEIVE = "LAB_INFO_RECEIVE";
	
	/**建库人员或现场物证比对质控对象*/
	public static final String NORMAL_OBJECT_COMPARE_QUALITY_CONTROL_OBJECT = "NORMAL_OBJECT_COMPARE_QUALITY_CONTROL_OBJECT";
	/**质控对象比对建库人员或现场物证*/
	public static final String QUALITY_CONTROL_OBJECT_COMPARE_NORMAL_OBJECT = "QUALITY_CONTROL_OBJECT_COMPARE_NORMAL_OBJECT";
	/**污染自动比对，匹配下限*/
	public static final String POLLUTION_SAME_LIMIT = "POLLUTION_SAME_LIMIT";
	/**污染自动比对，容差上限*/
	public static final String POLLUTION_DIFF_LIMIT = "POLLUTION_DIFF_LIMIT";
	
	/** pki 多维身份认证开关 */
	public static final String PKI_LOGIN_MULTID_VALIDATE = "PKI_LOGIN_MULTID_VALIDATE";
	
	/**最大条数限制开关*/
	public static final String MAX_NUMBER_SETTING_SWITCH = "MAX_NUMBER_SETTING_SWITCH";
	
	/**Y隐藏错误分型处理任务运行开关*/
	public static final String Y_GENE_TASK_RUN_SETTING_SWITCH = "Y_GENE_TASK_RUN_SETTING_SWITCH";
	
	/**同步队列状态错误数据处理任务运行开关*/
	public static final String SYNC_QUEUE_TASK_RUN_SETTING_SWITCH = "SYNC_QUEUE_TASK_RUN_SETTING_SWITCH";

	/**
	 * Y库回传基因分型接口配置
	 */
	public static final String YSTR_INTERFACE_LOADPERSONGENEINFO = "YSTR_INTERFACE_LOADPERSONGENE";
	/**
	 * Y库同步样本分型Y库用户id
	 */
	public static final String YSTR_INTERFACE_YSTRUSERID = "YSTR_INTERFACE_YSTRUSERID";

	/**打拐其他子女样本实验室编号回传运行开关*/
	public static final String DG_CHILD_SAMPLELABNO_TASK_RUN_SETTING_SWITCH = "DG_CHILD_SAMPLELABNO_TASK_RUN_SETTING_SWITCH";

	/**样本编号重复处理任务运行开关*/
	public static final String REPEAT_SAMPLENO_TASK_RUN_SETTING_SWITCH = "REPEAT_SAMPLENO_TASK_RUN_SETTING_SWITCH";

	/**
	 * 非法数据上报配置
	 */
	//category 非法数据上报配置项
	public final static String ILLEGAL_DATA_REPORT_CONFIG = "ILLEGAL_DATA_REPORT_CONFIG";
	//config_key 非法数据上报url
	public final static String ILLEGAL_DATA_REPORT_URL = "ILLEGAL_DATA_REPORT_URL";

	// 人脸登录超时时间
	public final static String FACE_LOGIN = "FACE_LOGIN";
	public final static String TIME_OUT = "TIME_OUT";


	/** 数据上报开关 */
	public static final String DATA_TRANSFER_SWITCH = "DATA_TRANSFER_SWITCH";


	/** 快比手工录分型开关 */
	public static final String FAST_MANUAL_INPUT_CONFIG = "FAST_MANUAL_INPUT_CONFIG";

	/** 现勘csims接口地址*/
	public static final String SCENE_INTERFACE_CSIMS = "SCENE_INTERFACE_CSIMS";
	public static final String SCENE_INTERFACE_CSIMS_TOKEN = "SCENE_INTERFACE_CSIMS_TOKEN";

	/** 快比混合比对分型开关 */
	public static final String FAST_MANUAL_MIX_CONFIG = "FAST_MANUAL_MIX_CONFIG";

	/** 多峰基因座配置 */
	public static final String GENE_MULTI_MODAL = "GENE_MULTI_MODAL";
	public static final String SYSTEM_CONFIG = "SYSTEM_CONFIG";
	public static final String REQUIRED_SWITCH = "REQUIRED_SWITCH";
	public static final String RELATION_CONFIG = "RELATION_CONFIG";
	public static final String RELATION_COMPUTE_URL = "RELATION_COMPUTE_URL";



    /**刑专单点登录接口配置*/
    public static final String XZ_INTERFACE_CONFIG = "XZ_INTERFACE_CONFIG";
    public static final String GET_USER_BY_TOKEN = "GET_USER_BY_TOKEN";
    public static final String APP_ID = "APP_ID";
    public static final String APP_KEY = "APP_KEY";
    public static final String APP_SECRET = "APP_SECRET";

}