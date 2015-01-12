public class Colors{
    private String hex = "0123456789ABCDEF";
    public static String intToHex(int val){
	return hex[val/16] + hex[val%16];
    }


}