package com.example.myapplication.bean

/**
 * @author bao
 * @description:
 * @date :2019/11/12 11:41
 */
data class LoginDataBean (var uId:String?,var uImage:String?,var uNickname:String?,var uMobile:String?

                ,var uDvcid:String?,var sid:String?,var identifyList:List<IdentifyListBean>?,var failNum:Int) {
//    public String uId;
//    public String uNickname;
//    public String uImage;
//    public String uMobile;
//    public String uToken;
//    public String expand;
//    public int failNum;
//    public int passFailNum;
//    public String uDvcid;
//    public int isFirstLogin;
//    public List<LoginDataBean.IdentifyListBean> identifyList;
//    public String sid;
//    private static final long serialVersionUID = 223456789L;
//
//    public LoginDataBean() {
//    }
//
//    public static class IdentifyListBean {
//        public String idNo;
//        public String userName;
//        public int idType;
//
//        public IdentifyListBean() {
//        }
//    }
}

data class IdentifyListBean(var idNo:String?,var userName:String?,var idType:Int){}