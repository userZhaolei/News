package com.example.a3559dell.headlinestoday_demo.mobel;

import java.util.List;

/**
 * Created by 3559dell on 2017/7/20.
 */
public class MyBean {

    /**
     * size : 10
     * list : [{"imgurl":"http://cms-bucket.nosdn.127.net/87c8ef093a744507a193da34ff555cae20170720153656.jpeg","has_content":true,"docurl":"http://sports.163.com/17/0720/15/CPQ36QV20005877V.html","id":17003,"time":"2017-07-20 15:36:31","title":"北控小将为马布里让出3号球衣 球队或在8月备战","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/5ef9e975189b4f15ac654a289ebaa04820170720153159.png","has_content":true,"docurl":"http://sports.163.com/17/0720/15/CPQ2UN8K00058781.html","id":17001,"time":"2017-07-20 15:32:05","title":"阿森纳确认球员不适非食物中毒 40度高温成罪魁","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/823b1a2c2626415b9ff581a1074a487720170720153033.jpeg","has_content":true,"docurl":"http://sports.163.com/17/0720/15/CPQ2R4F20005877V.html","id":17005,"time":"2017-07-20 15:30:07","title":"睢冉致敬老马:你的生涯精彩辉煌 享受最后一赛季","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/fa4fccc4be3a48cab2e923a4b0463b5820170720152545.jpeg","has_content":true,"docurl":"http://sports.163.com/17/0720/15/CPQ2IE8T0005877V.html","id":17004,"time":"2017-07-20 15:25:22","title":"追随马布里OR首钢?京媒:考验北京球迷的时候到了","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/6d8a39a893cc4db69da18e6b56badac120170720152215.png","has_content":true,"docurl":"http://sports.163.com/17/0720/15/CPQ2EGTO00058781.html","id":17002,"time":"2017-07-20 15:23:14","title":"穆帅:不关心蓝军签莫拉塔 卢卡库能力欧洲顶级","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/a9ea4258c29542858bc045bde79ece5f20170720151137.jpeg","has_content":true,"docurl":"http://sports.163.com/17/0720/15/CPQ1MDPR0005877V.html","id":17000,"time":"2017-07-20 15:10:04","title":"有种外援叫＂姚明前队友＂ 火箭17将曾来CBA淘金","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/c571c6cdf67d484c987b274103b4259b20170720143404.png","has_content":true,"docurl":"http://sports.163.com/17/0720/14/CPPVKNKA00058782.html","id":16963,"time":"2017-07-20 14:34:12","title":"前橄榄球明星辛普森假释听证20日举行 将进行直播","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/b5b2dc9a18ca443dae229075b4cbad0220170720135320.png","has_content":true,"docurl":"http://sports.163.com/17/0720/13/CPPSU5JU0005876K.html","id":16951,"time":"2017-07-20 13:46:55","title":"从九球天后到全能女神 潘晓婷获最佳跨界人物奖","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/71732e1dfbc1416680b859bac11024a020170720132128.png","has_content":true,"docurl":"http://sports.163.com/17/0720/13/CPPS7SPH00058782.html","id":16943,"time":"2017-07-20 13:34:45","title":"羽联半赛季奖金:林丹李宗伟收入总和不如印度名将","channelname":"sport"},{"imgurl":"http://cms-bucket.nosdn.127.net/0e3c6cc8fab1472dbc5989695419987d20170720132016.png","has_content":true,"docurl":"http://sports.163.com/17/0720/13/CPPRF3RR00058780.html","id":16941,"time":"2017-07-20 13:21:13","title":"王上源:肮脏话侮辱我家人的喷子 住下水道都不配","channelname":"sport"}]
     */

    private int size;
    private List<ListBean> list;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * imgurl : http://cms-bucket.nosdn.127.net/87c8ef093a744507a193da34ff555cae20170720153656.jpeg
         * has_content : true
         * docurl : http://sports.163.com/17/0720/15/CPQ36QV20005877V.html
         * id : 17003
         * time : 2017-07-20 15:36:31
         * title : 北控小将为马布里让出3号球衣 球队或在8月备战
         * channelname : sport
         */

        private String imgurl;
        private boolean has_content;
        private String docurl;
        private int id;
        private String time;
        private String title;
        private String channelname;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public boolean isHas_content() {
            return has_content;
        }

        public void setHas_content(boolean has_content) {
            this.has_content = has_content;
        }

        public String getDocurl() {
            return docurl;
        }

        public void setDocurl(String docurl) {
            this.docurl = docurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelname() {
            return channelname;
        }

        public void setChannelname(String channelname) {
            this.channelname = channelname;
        }
    }
}
