package test;

import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.GsonUtils;
import com.bejson.pojo.Face_list;
import com.bejson.pojo.JsonRootBean;

import java.io.File;
import java.util.*;

/**
* 人脸检测与属性分析
*/
public class FaceDetect {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String faceDetect(String filePath) {
        // 请求url
        File file = new File(filePath);
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", Base64Util.encode(FileUtil.readFileByBytes(filePath)));
            map.put("face_field", "face_num,location,age,beauty,gender,emotion,mask,spoofing");
            map.put("image_type", "BASE64");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // public static void main(String[] args) {
    //     String resultjson = FaceDetect.faceDetect("/Users/yingfc/Desktop/证件信息/陈颖凡.JPG");
    //     System.out.println(resultjson);
    //     JsonRootBean rootBean = GsonUtils.fromJson(resultjson, JsonRootBean.class);
    //     List<Face_list> list = rootBean.result.face_list;
    //     System.out.println("年龄: " + list.get(0).getAge());
    //     System.out.println("颜值: " + list.get(0).getBeauty());
    //     System.out.println("情绪: " + list.get(0).getEmotion().getType());
    //     System.out.println("性别: " + list.get(0).getGender().getType());
    // }
}