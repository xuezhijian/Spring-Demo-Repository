//package cn.xuezhijian2.core.mybatis;
//
///**
// * Created with IntelliJ IDEA.
// * packageName  : cn.xuezhijian2.core.mybatis
// * User         : zj
// * Date         : 17/4/16
// * Time         : 上午1:19
// * Description  :
// */
//
//public class DataSourceContextHolder {
//
//    private static final ThreadLocal<String> dataSourceLocal = new ThreadLocal<>();
//
//    public static ThreadLocal<String> getDataSourceLocal(){
//        return  dataSourceLocal;
//    }
//
//    /**
//     * 主库 只有一个
//     */
//    public static void primary(){
//        dataSourceLocal.set(TargetDataSource.PRIMARY.getCode());
//    }
//
//    /**
//     * 从库 可以有多个
//     */
//    public static void auxiliary(){
//        dataSourceLocal.set(TargetDataSource.AUXILIARY.getCode());
//    }
//
//    public static String getTargetDataSource(){
//        return dataSourceLocal.get();
//    }
//
//}
