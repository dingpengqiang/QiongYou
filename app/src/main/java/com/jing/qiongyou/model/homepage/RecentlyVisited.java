package com.jing.qiongyou.model.homepage;

import java.util.List;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 */

public class RecentlyVisited {


    /**
     * status : 1
     * info :
     * times : 0
     * data : {"title":"最近访问","city_id":63,"type":2,"city_name":"东京","cover":"http://pic1.qyer.com/album/123/c8/1866577/index/710x360","tab":[{"name":"景点玩乐","icon_type":"play","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/29/14697805314391"},{"name":"美食","icon_type":"food","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/29/14697806029201"},{"name":"锦囊","icon_type":"qyerguide","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684641611157"},{"name":"收藏目的地","icon_type":"poilike","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684645023549"}],"recommend_city":[{"id":31,"city_name":"佛罗伦萨","city_type":2},{"id":9492,"city_name":"巴厘岛","city_type":2},{"id":68,"city_name":"墨尔本","city_type":2}],"discount":{}}
     * extra : {"ra_switch":1}
     * ra_referer :
     */

    private int status;
    private String info;
    private int times;
    private DataBean data;
    private ExtraBean extra;
    private String ra_referer;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ExtraBean getExtra() {
        return extra;
    }

    public void setExtra(ExtraBean extra) {
        this.extra = extra;
    }

    public String getRa_referer() {
        return ra_referer;
    }

    public void setRa_referer(String ra_referer) {
        this.ra_referer = ra_referer;
    }

    public static class DataBean {
        /**
         * title : 最近访问
         * city_id : 63
         * type : 2
         * city_name : 东京
         * cover : http://pic1.qyer.com/album/123/c8/1866577/index/710x360
         * tab : [{"name":"景点玩乐","icon_type":"play","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/29/14697805314391"},{"name":"美食","icon_type":"food","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/29/14697806029201"},{"name":"锦囊","icon_type":"qyerguide","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684641611157"},{"name":"收藏目的地","icon_type":"poilike","icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684645023549"}]
         * recommend_city : [{"id":31,"city_name":"佛罗伦萨","city_type":2},{"id":9492,"city_name":"巴厘岛","city_type":2},{"id":68,"city_name":"墨尔本","city_type":2}]
         * discount : {}
         */

        private String title;
        private int city_id;
        private int type;
        private String city_name;
        private String cover;
        private DiscountBean discount;
        private List<TabBean> tab;
        private List<RecommendCityBean> recommend_city;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public DiscountBean getDiscount() {
            return discount;
        }

        public void setDiscount(DiscountBean discount) {
            this.discount = discount;
        }

        public List<TabBean> getTab() {
            return tab;
        }

        public void setTab(List<TabBean> tab) {
            this.tab = tab;
        }

        public List<RecommendCityBean> getRecommend_city() {
            return recommend_city;
        }

        public void setRecommend_city(List<RecommendCityBean> recommend_city) {
            this.recommend_city = recommend_city;
        }

        public static class DiscountBean {
        }

        public static class TabBean {
            /**
             * name : 景点玩乐
             * icon_type : play
             * icon_url : http://pic.qyer.com/public/place/iconconfig/2016/07/29/14697805314391
             */

            private String name;
            private String icon_type;
            private String icon_url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon_type() {
                return icon_type;
            }

            public void setIcon_type(String icon_type) {
                this.icon_type = icon_type;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }
        }

        public static class RecommendCityBean {
            /**
             * id : 31
             * city_name : 佛罗伦萨
             * city_type : 2
             */

            private int id;
            private String city_name;
            private int city_type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public int getCity_type() {
                return city_type;
            }

            public void setCity_type(int city_type) {
                this.city_type = city_type;
            }
        }
    }

    public static class ExtraBean {
        /**
         * ra_switch : 1
         */

        private int ra_switch;

        public int getRa_switch() {
            return ra_switch;
        }

        public void setRa_switch(int ra_switch) {
            this.ra_switch = ra_switch;
        }
    }
}
