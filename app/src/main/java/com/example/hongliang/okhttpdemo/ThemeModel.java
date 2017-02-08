package com.example.hongliang.okhttpdemo;

import java.util.List;

/**
 * Created by hongliang on 2017/2/7.
 */

public class ThemeModel {

    /**
     * code : 0
     * msg : 成功
     * data : [{"value":"467aa3d2-7394-4d4b-b087-d4ebe558d3e9","title":"温泉情人节","pic":"http://source.1000fun.com/3da88789-ff9f-45dd-a8d0-a36f74d0ac73.jpg?w=1250&imageMogr2/format/webp&h=500","type":"1"},{"value":"http://mp.weixin.qq.com/s?__biz=MzI4MjEyMTU3NQ==&mid=2648755318&idx=1&sn=7b2faab520ab8f7bda50a6c099774c21&chksm=f38aa87ec4fd2168326d0b36d6b9e743fe59f9dc2821857f1c70d2cb158a05bbcf1672c78beb#rd","title":"一段没有分别的旅程","pic":"http://source.1000fun.com/34a12ac7-9861-42d5-99a1-1ea1b343be3c.jpg?w=1250&imageMogr2/format/webp&h=500","type":"3"},{"value":"http://go.1000fun.com/weixin/share/new","title":"200元新手礼包","pic":"http://source.1000fun.com/5aca913f-1531-442e-95db-4aa891a47ae8.png?w=1250&imageMogr2/format/webp&h=500","type":"3"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * value : 467aa3d2-7394-4d4b-b087-d4ebe558d3e9
         * title : 温泉情人节
         * pic : http://source.1000fun.com/3da88789-ff9f-45dd-a8d0-a36f74d0ac73.jpg?w=1250&imageMogr2/format/webp&h=500
         * type : 1
         */

        private String value;
        private String title;
        private String pic;
        private String type;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "value='" + value + '\'' +
                    ", title='" + title + '\'' +
                    ", pic='" + pic + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ThemeModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
