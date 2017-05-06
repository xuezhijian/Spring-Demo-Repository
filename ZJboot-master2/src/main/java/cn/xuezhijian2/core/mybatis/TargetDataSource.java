//package cn.xuezhijian2.core.mybatis;
//
///**
// * Created with IntelliJ IDEA.
// * packageName  : cn.xuezhijian2.core.mybatis
// * Company      : 彼得科技
// * User         : zj
// * Date         : 17/4/16
// * Time         : 上午1:20
// * Description  :
// */
//
//public enum TargetDataSource {
//
//    PRIMARY("primary","主库"), AUXILIARY("auxiliary","从库");
//
//    final private String code;
//
//    final private String name;
//
//    TargetDataSource(String _code,String _name) {
//        this.code = _code;
//        this.name = _name;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public static String getNameByCode(String _code){
//        for(TargetDataSource item : TargetDataSource.values()){
//            if(item.getCode().equals(_code))
//            {
//                return item.getName();
//            }
//        }
//        return "";
//    }
//
//}
