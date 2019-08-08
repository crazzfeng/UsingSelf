package testLamda;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yufeng li
 * @title: TestLambda
 * @description:
 * @date 2019/7/25 10:47
 */
public class TestLambda {

    public static void main(String[] args) {

    /*    List<BusinessInspection> businessInspections = new ArrayList<>();

        List<BusinessInspection> inspections = businessInspections.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() ->
                                new TreeSet<BusinessInspection>(Comparator.comparing(BusinessInspection::getEnterName))),
                        ArrayList::new)
                );

        for (BusinessInspection businessInspection : inspections) {
            System.err.println(businessInspection.toString());
        }*/

       /* String s = "sdsaf测试员工个";
        try {
            String b = URLEncoder.encode(s, "utf-8");
            System.err.println(b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
       /* byte[] bytes = s.getBytes(StandardCharsets.);
        String b = new String(bytes);*/

       /* Properties properties = System.getProperties();
        System.err.println(properties);*/
String path = "http://192.168.0.30/subject/5253";
        String obj = "{\"photo_ids\":[7045],\n" +
                "\"subject_type\":0,\n" +
                "\"gender\":1,\n" +
                "\"phone\":\"13865594482\",\n" +
                "\"name\":\"测试123234\",\n" +
                "\"job_number\":\"Cs2698\",\n" +
                "\"avatar\": \"/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAUDBAQEAwUEBAQFBQUGBwwIBwcHBw8LCwkMEQ8SEhEPERETFhwXExQaFRERGCEYGh0dHx8fExciJCIeJBweHx7/2wBDAQUFBQcGBw4ICA4eFBEUHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh7/wAARCALMAswDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD30daTHXNLRn0696kAHTnp2ptOOcUfhQA3rxQQoHPJ9acegoNHMVyjfxprdakH3TTcUAHVcUmD/epRTjSAjPX196cFbFFOXpQA08jFBXij+E/WlU54oAaRwKBT8Y5pobmgAFO\",\n" +
                "\"title\":\"经理123\"\n" +
                "\t\n" +
                "}";

        try {
            URL url = new URL(path);
            HttpURLConnection connection;
            StringBuffer sbuffer = null;
            //添加 请求内容
            connection = (HttpURLConnection) url.openConnection();
            //设置http连接属性
            connection.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false;
            connection.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
            connection.setRequestMethod("PUT"); // 可以根据需要 提交 GET、POST、DELETE、PUT等http提供的功能
            //connection.setUseCaches(false);//设置缓存，注意设置请求方法为post不能用缓存
            // connection.setInstanceFollowRedirects(true);

            //connection.setRequestProperty("Host", "192.168.0.30");  //设置请 求的服务器网址，域名，例如***.**.***.***
            //connection.setRequestProperty("Content-Type", " application/json");//设定 请求格式 json，也可以设定xml格式的
            //connection.setRequestProperty("Accept-Charset", "utf-8");  //设置编码语言
            //connection.setRequestProperty("X-Auth-Token", "1ce819d2-9903-4eeb-af37-9d7f0df51490,985c62cf-32c1-4483-9612-987ead72338d");  //设置请求的token
            //connection.setRequestProperty("Connection", "keep-alive");  //设置连接的状态
            //connection.setRequestProperty("Transfer-Encoding", "chunked");//设置传输编码
            //connection.setRequestProperty("Content-Length", obj.toString().getBytes().length + ""); //设置文件请求的长度
            connection.setRequestProperty("Host","192.168.0.30");
            connection.setRequestProperty("Connection","keep-alive");
            connection.setRequestProperty("Pragma","no-cache");
            connection.setRequestProperty("Cache-Control","no-cache");
            connection.setRequestProperty("Accept","application/json, text/javascript, */*; q=0.01");
            connection.setRequestProperty("X-Requested-With","XMLHttpRequest");
            connection.setRequestProperty("X-FirePHP-Version","0.0.6");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
            connection.setRequestProperty("Referer","http://192.168.0.30/subject/employee");
            connection.setRequestProperty("Accept-Encoding","gzip, deflate");
            connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
            connection.setRequestProperty("Cookie","session=ba7f7ef3-3518-4585-984c-f2633e0c968f,session=ba7f7ef3-3518-4585-984c-f2633e0c968f; session=ba7f7ef3-3518-4585-984c-f2633e0c968f");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("Postman-Token","f14acec2-25f1-402d-bd7f-91ceced8d27b,2725ffa9-90d5-4756-a7bf-efb8b99afe22");
            connection.setRequestProperty("Content-Length","1172");
            connection.setRequestProperty("cache-control","no-cache");
            connection.setReadTimeout(10000);//设置读取超时时间          
            connection.setConnectTimeout(10000);//设置连接超时时间           
            connection.connect();
            OutputStream out = connection.getOutputStream();//向对象输出流写出数据，这些数据将存到内存缓冲区中          
            out.write( URLEncoder.encode(obj.toString()).getBytes());            //out.write(new String("测试数据").getBytes());            //刷新对象输出流，将任何字节都写入潜在的流中       
            out.flush();
            // 关闭流对象,此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中          
            out.close();
            //读取响应           
            if (connection.getResponseCode() == 200) {
                // 从服务器获得一个输入流
                InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());//调用HttpURLConnection连接对象的getInputStream()函数, 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
                BufferedReader reader = new BufferedReader(inputStream);

                String lines;
                sbuffer = new StringBuffer("");
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes());
                    sbuffer.append(lines);
                }
                reader.close();
            } else {
                System.err.println(connection.getResponseMessage());
                throw new ClientProtocolException("请求失败" + connection.getResponseCode());
            }
            //断开连接           
            connection.disconnect();
            String res =  URLEncoder.encode(sbuffer.toString(),"UTF-8");
            System.err.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public class BusinessInspection {

        /**    */
        private String id;
        /**
         * 园区id
         */
        private String parkId;
        /**
         * 分期id
         */
        private String stageId;
        /**
         * 楼栋id
         */
        private String buildId;
        /**
         * 单元id
         */
        private String unitNo;
        /**
         * 楼层id
         */
        private String groundNo;
        /**
         * 空间id
         */
        private String houseId;
        /**
         * 空间编码
         */
        private String houseCode;
        /**
         * 空间名称
         */
        private String houseName;
        /**
         * 巡检类型（1-商业，2-办公）
         */
        private Integer inspectionType;
        /**
         * 业态类型（1-餐饮，2-商业）
         */
        private Integer businessType;
        /**
         * 入驻方
         */
        private String enterName;
        /**
         * 联系方式
         */
        private String phone;
        /**
         * 品牌名称
         */
        private String brand;
        /**
         * 品牌照片
         */
        private String brandImg;
        /**
         * 照片（限制最多三张）
         */
        private String img;
        /**
         * 空间经度
         */
        private Double longitude;
        /**
         * 空间纬度
         */
        private Double latitude;
        /**
         * 巡检时间
         */
        private Date inspectionTime;
        /**
         * 备注
         */
        private String remark;
        /**
         * 数据有效性,0:删除, 1:有效
         */
        private Integer dataStatus;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 创建人id
         */
        private String creatorId;
        /**
         * 创建人名称
         */
        private String creatorName;
        /**
         * 修改时间
         */
        private Date updateTime;
        /**
         * 修改人id
         */
        private String updatorId;
        /**
         * 修改人名称
         */
        private String updatorName;

        //冗余字段
        private String stageName;
        private String buildName;

        private Date inspectionTimeStart;
        private Date inspectionTimeEnd;

        public BusinessInspection() {
        }

        /**
         * 获取属性：
         */
        public String getId() {
            return this.id;
        }


        /**
         * 设置属性：
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * 获取属性：园区id
         */
        public String getParkId() {
            return this.parkId;
        }


        /**
         * 设置属性：园区id
         */
        public void setParkId(String parkId) {
            this.parkId = parkId;
        }

        /**
         * 获取属性：分期id
         */
        public String getStageId() {
            return this.stageId;
        }


        /**
         * 设置属性：分期id
         */
        public void setStageId(String stageId) {
            this.stageId = stageId;
        }

        /**
         * 获取属性：楼栋id
         */
        public String getBuildId() {
            return this.buildId;
        }


        /**
         * 设置属性：楼栋id
         */
        public void setBuildId(String buildId) {
            this.buildId = buildId;
        }

        /**
         * 获取属性：单元No
         */
        public String getUnitNo() {
            return this.unitNo;
        }


        /**
         * 设置属性：单元No
         */
        public void setUnitNo(String unitNo) {
            this.unitNo = unitNo;
        }

        /**
         * 获取属性：楼层No
         */
        public String getGroundNo() {
            return groundNo;
        }

        /**
         * 设置属性：楼层No
         */
        public void setGroundNo(String groundNo) {
            this.groundNo = groundNo;
        }

        /**
         * 获取属性：空间id
         */
        public String getHouseId() {
            return this.houseId;
        }


        /**
         * 设置属性：空间id
         */
        public void setHouseId(String houseId) {
            this.houseId = houseId;
        }

        /**
         * 获取属性：空间编码
         */
        public String getHouseCode() {
            return this.houseCode;
        }


        /**
         * 设置属性：空间编码
         */
        public void setHouseCode(String houseCode) {
            this.houseCode = houseCode;
        }

        /**
         * 获取属性：空间名称
         */
        public String getHouseName() {
            return this.houseName;
        }


        /**
         * 设置属性：空间名称
         */
        public void setHouseName(String houseName) {
            this.houseName = houseName;
        }

        /**
         * 获取属性：巡检类型（1-商业，2-办公）
         */
        public Integer getInspectionType() {
            return inspectionType;
        }

        /**
         * 设置属性：巡检类型（1-商业，2-办公）
         */
        public void setInspectionType(Integer inspectionType) {
            this.inspectionType = inspectionType;
        }

        /**
         * 获取属性：业态类型（1-餐饮，2-商业）
         */
        public Integer getBusinessType() {
            return this.businessType;
        }


        /**
         * 设置属性：业态类型（1-餐饮，2-商业）
         */
        public void setBusinessType(Integer businessType) {
            this.businessType = businessType;
        }

        /**
         * 获取属性：入驻方
         */
        public String getEnterName() {
            return this.enterName;
        }


        /**
         * 设置属性：入驻方
         */
        public void setEnterName(String enterName) {
            this.enterName = enterName;
        }

        /**
         * 获取属性：联系方式
         */
        public String getPhone() {
            return this.phone;
        }


        /**
         * 设置属性：联系方式
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * 获取属性：品牌
         */
        public String getBrand() {
            return this.brand;
        }


        /**
         * 设置属性：品牌
         */
        public void setBrand(String brand) {
            this.brand = brand;
        }

        /**
         * 获取属性：品牌照片（限制最多三张）
         */
        public String getBrandImg() {
            return brandImg;
        }

        /**
         * 设置属性：品牌照片（限制最多三张）
         */
        public void setBrandImg(String brandImg) {
            this.brandImg = brandImg;
        }

        /**
         * 获取属性：照片（限制最多三张）
         */
        public String getImg() {
            return this.img;
        }


        /**
         * 设置属性：照片（限制最多三张）
         */
        public void setImg(String img) {
            this.img = img;
        }

        /**
         * 获取属性：空间经度
         */
        public Double getLongitude() {
            return this.longitude;
        }


        /**
         * 设置属性：空间经度
         */
        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        /**
         * 获取属性：空间纬度
         */
        public Double getLatitude() {
            return this.latitude;
        }


        /**
         * 设置属性：空间纬度
         */
        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        /**
         * 获取属性：巡检时间
         */
        public Date getInspectionTime() {
            return this.inspectionTime;
        }


        /**
         * 设置属性：巡检时间
         */
        public void setInspectionTime(Date inspectionTime) {
            this.inspectionTime = inspectionTime;
        }

        /**
         * 设置属性：备注
         */
        public String getRemark() {
            return remark;
        }

        /**
         * 获取属性：备注
         */
        public void setRemark(String remark) {
            this.remark = remark;
        }

        /**
         * 获取属性：数据有效性,0:删除, 1:有效
         */
        public Integer getDataStatus() {
            return this.dataStatus;
        }


        /**
         * 设置属性：数据有效性,0:删除, 1:有效
         */
        public void setDataStatus(Integer dataStatus) {
            this.dataStatus = dataStatus;
        }

        /**
         * 获取属性：创建时间
         */
        public Date getCreateTime() {
            return this.createTime;
        }


        /**
         * 设置属性：创建时间
         */
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        /**
         * 获取属性：创建人id
         */
        public String getCreatorId() {
            return this.creatorId;
        }


        /**
         * 设置属性：创建人id
         */
        public void setCreatorId(String creatorId) {
            this.creatorId = creatorId;
        }

        /**
         * 获取属性：创建人名称
         */
        public String getCreatorName() {
            return this.creatorName;
        }


        /**
         * 设置属性：创建人名称
         */
        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
        }

        /**
         * 获取属性：修改时间
         */
        public Date getUpdateTime() {
            return this.updateTime;
        }


        /**
         * 设置属性：修改时间
         */
        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        /**
         * 获取属性：修改人id
         */
        public String getUpdatorId() {
            return this.updatorId;
        }


        /**
         * 设置属性：修改人id
         */
        public void setUpdatorId(String updatorId) {
            this.updatorId = updatorId;
        }

        /**
         * 获取属性：修改人名称
         */
        public String getUpdatorName() {
            return this.updatorName;
        }


        /**
         * 设置属性：修改人名称
         */
        public void setUpdatorName(String updatorName) {
            this.updatorName = updatorName;
        }

        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }

        public String getBuildName() {
            return buildName;
        }

        public void setBuildName(String buildName) {
            this.buildName = buildName;
        }

        public Date getInspectionTimeStart() {
            return inspectionTimeStart;
        }

        public void setInspectionTimeStart(Date inspectionTimeStart) {
            this.inspectionTimeStart = inspectionTimeStart;
        }

        public Date getInspectionTimeEnd() {
            return inspectionTimeEnd;
        }

        public void setInspectionTimeEnd(Date inspectionTimeEnd) {
            this.inspectionTimeEnd = inspectionTimeEnd;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("BusinessInspection[");
            builder.append(" [id] = ");
            builder.append(this.id);
            builder.append(" 空间id[houseId] = ");
            builder.append(this.houseId);
            builder.append(" 业态类型（1-餐饮，2-商业）[businessType] = ");
            builder.append(this.businessType);
            builder.append(" 入驻方[enterName] = ");
            builder.append(this.enterName);
            builder.append(" 联系方式[phone] = ");
            builder.append(this.phone);
            builder.append(" 品牌[brand] = ");
            builder.append(this.brand);
            builder.append(" 照片（限制最多三张）[img] = ");
            builder.append(this.img);
            builder.append(" 空间经度[longitude] = ");
            builder.append(this.longitude);
            builder.append(" 空间纬度[latitude] = ");
            builder.append(this.latitude);
            builder.append(" 巡检时间[inspectionTime] = ");
            builder.append(this.inspectionTime);
            builder.append(" 数据有效性,0:删除, 1:有效[dataStatus] = ");
            builder.append(this.dataStatus);
            builder.append(" 创建时间[createTime] = ");
            builder.append(this.createTime);
            builder.append(" 创建人id[creatorId] = ");
            builder.append(this.creatorId);
            builder.append(" 创建人名称[creatorName] = ");
            builder.append(this.creatorName);
            builder.append(" 修改时间[updateTime] = ");
            builder.append(this.updateTime);
            builder.append(" 修改人id[updatorId] = ");
            builder.append(this.updatorId);
            builder.append(" 修改人名称[updatorName] = ");
            builder.append(this.updatorName);
            builder.append("]");
            return builder.toString();
        }
    }

}
