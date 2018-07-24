package cn.com.ctsi.busiobj.util;


import cn.com.ctsi.busiobj.bean.base.BaseResponse;
import cn.com.ctsi.busiobj.bean.base.BaseResponseNoBody;
import cn.com.ctsi.busiobj.bean.base.GeneralResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Configuration
public class ParamUtil {

    private static final Integer COLUMN_TYPE_BOOL=1;//布尔类型
    private static final Integer COLUMN_TYPE_INTEGER=2;//Integer类型
    private static final Integer COLUMN_TYPE_FLOAT=3;//float类型
    private static final Integer COLUMN_TYPE_DOUBLE=4;//double类型
    private static final Integer COLUMN_TYPE_STRING=5;//string类型
    private static final Integer COLUMN_TYPE_DATETIME=6;//yyyy-MM-dd HH:mm:ss类型
    private static final Integer COLUMN_TYPE_GEOMETRY_POINT=7;//点
    private static final Integer COLUMN_TYPE_GEOMETRY_LINE=8;//线
    private static final Integer COLUMN_TYPE_GEOMETRY_POLYGON=9;//面
    private static final Integer COLUMN_TYPE_KEY_VALUE_RADIO=10;//单选
    private static final Integer COLUMN_TYPE_LOCATION=11;//location类型
    private static final Integer COLUMN_TYPE_PICTURE=12;//图片
    private static final Integer COLUMN_TYPE_VIDEO=13;//视频
    private static final Integer COLUMN_TYPE_METATABLE=14;//表类型为模板时使用
    private static final Integer COLUMN_TYPE_LOCATION_NEW=15;//质询相互位置点类型和位置描述
    private static final Integer COLUMN_TYPE_AUDIO=16;//音频类型
    private static final Integer COLUMN_TYPE_FILE=17;//附件类型
    private static final Integer COLUMN_TYPE_KEY_VALUE_CHECK=18;//多选类型
    private static final Integer COLUMN_TYPE_TEXT=19;//文本域类型

    private static final Integer WHERE_FILTER_TYPE_EQUAL=1;//等于
    private static final Integer WHERE_FILTER_TYPE_NEQUAL=2;//不等于
    private static final Integer WHERE_FILTER_TYPE_LIKE=3;
    private static final Integer WHERE_FILTER_TYPE_NLIKE=4;//
    private static final Integer WHERE_FILTER_TYPE_GREATHAN=5;//大于
    private static final Integer WHERE_FILTER_TYPE_GREATHANANDEQUAL=6;//大于等于
    private static final Integer WHERE_FILTER_TYPE_LOWERTHAN=7;//小于
    private static final Integer WHERE_FILTER_TYPE_LOWERTHANANDEQUAL=8;//小于等于
    private static final Integer WHERE_FILTER_TYPE_BETWEEN=9;
    private static final Integer WHERE_FILTER_TYPE_IN=10;
    private static final Integer WHERE_FILTER_TYPE_NOT_IN=11;
    private static final Integer WHERE_FILTER_TYPE_NEAR=12;


    private static final Integer SHOW_STYLE_STRING=1;//显示格式中大类为1
    private static final String SHOW_STYLE_DEPT_TREE="1,8-2";//部门树
    private static final String SHOW_STYLE_USER_TREE="1,8-1";//人员树

    private static final String FILE_UP_NEED_THUMBURL_TYPES="jpg|jpeg|gif|png|bmp|tiff|psd|raw|swf|svg";
    private static final String FILE_UP_ALL_SURPORTED_TYPES="jpg|png|gif|txt|doc|xls|docx|xlsx|jpeg|pdf|mp3|ppt|pptx|bmp|zip|rar|mp4|3gp|avi|wmv|mpeg|mov|mkv|flv|f4v|m4v|rmvb|rm|dat|ts|mts|vob|tiff|psd|raw|swf|svg|apk";


    public static Integer getColumnTypeBool() {
        return COLUMN_TYPE_BOOL;
    }

    public static Integer getColumnTypeInteger() {
        return COLUMN_TYPE_INTEGER;
    }

    public static Integer getColumnTypeFloat() {
        return COLUMN_TYPE_FLOAT;
    }

    public static Integer getColumnTypeDouble() {
        return COLUMN_TYPE_DOUBLE;
    }

    public static Integer getColumnTypeDatetime() {
        return COLUMN_TYPE_DATETIME;
    }

    public static Integer getColumnTypeKeyValueRadio() {
        return COLUMN_TYPE_KEY_VALUE_RADIO;
    }

    public static Integer getColumnTypeKeyValueCheck() {
        return COLUMN_TYPE_KEY_VALUE_CHECK;
    }

    public static Integer getWhereFilterTypeIn() {
        return WHERE_FILTER_TYPE_IN;
    }

    public static Integer getWhereFilterTypeBetween() {
        return WHERE_FILTER_TYPE_BETWEEN;
    }

    public static Integer getColumnTypeString() {
        return COLUMN_TYPE_STRING;
    }

    public static Integer getColumnTypeGeometryPoint() {
        return COLUMN_TYPE_GEOMETRY_POINT;
    }

    public static Integer getColumnTypeGeometryLine() {
        return COLUMN_TYPE_GEOMETRY_LINE;
    }

    public static Integer getColumnTypeGeometryPolygon() {
        return COLUMN_TYPE_GEOMETRY_POLYGON;
    }

    public static Integer getColumnTypeLocation() {
        return COLUMN_TYPE_LOCATION;
    }

    public static Integer getColumnTypePicture() {
        return COLUMN_TYPE_PICTURE;
    }

    public static Integer getColumnTypeVideo() {
        return COLUMN_TYPE_VIDEO;
    }

    public static Integer getColumnTypeMetatable() {
        return COLUMN_TYPE_METATABLE;
    }

    public static Integer getColumnTypeLocationNew() {
        return COLUMN_TYPE_LOCATION_NEW;
    }

    public static Integer getColumnTypeAudio() {
        return COLUMN_TYPE_AUDIO;
    }

    public static Integer getColumnTypeFile() {
        return COLUMN_TYPE_FILE;
    }

    public static Integer getColumnTypeText() {
        return COLUMN_TYPE_TEXT;
    }

    public static Integer getShowStyleString() {
        return SHOW_STYLE_STRING;
    }

    public static Integer getWhereFilterTypeEqual() {
        return WHERE_FILTER_TYPE_EQUAL;
    }

    public static Integer getWhereFilterTypeNequal() {
        return WHERE_FILTER_TYPE_NEQUAL;
    }

    public static Integer getWhereFilterTypeLike() {
        return WHERE_FILTER_TYPE_LIKE;
    }

    public static Integer getWhereFilterTypeNlike() {
        return WHERE_FILTER_TYPE_NLIKE;
    }

    public static Integer getWhereFilterTypeGreathan() {
        return WHERE_FILTER_TYPE_GREATHAN;
    }

    public static Integer getWhereFilterTypeGreathanandequal() {
        return WHERE_FILTER_TYPE_GREATHANANDEQUAL;
    }

    public static Integer getWhereFilterTypeLowerthan() {
        return WHERE_FILTER_TYPE_LOWERTHAN;
    }

    public static Integer getWhereFilterTypeLowerthanandequal() {
        return WHERE_FILTER_TYPE_LOWERTHANANDEQUAL;
    }

    public static Integer getWhereFilterTypeNotIn() {
        return WHERE_FILTER_TYPE_NOT_IN;
    }

    public static Integer getWhereFilterTypeNear() {
        return WHERE_FILTER_TYPE_NEAR;
    }

    public static String getFileUpNeedThumburlTypes() {
        return FILE_UP_NEED_THUMBURL_TYPES;
    }

    public static String getFileUpAllSurportedTypes() {
        return FILE_UP_ALL_SURPORTED_TYPES;
    }

    public static String getShowStyleDeptTree() {
        return SHOW_STYLE_DEPT_TREE;
    }

    public static String getShowStyleUserTree() {
        return SHOW_STYLE_USER_TREE;
    }

    public static void requestParamCheck(BaseResponseNoBody res, BindingResult result){
        if(result.hasErrors()){
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage(result.getAllErrors().get(0).getDefaultMessage());
        }
    }

    public static void requestParamCheck(BaseResponse res, BindingResult result){
        if(result.hasErrors()){
            res.setCode(BaseResponse.API_RESULT_FAIL);
            res.setMessage(result.getAllErrors().get(0).getDefaultMessage());
        }
    }

    public static void requestParamCheck(GeneralResponse res, BindingResult result){
        if(result.hasErrors()){
            res.setCode(GeneralResponse.CODE_FAIL);
            res.setInfo(result.getAllErrors().get(0).getDefaultMessage());
        }
    }
}
