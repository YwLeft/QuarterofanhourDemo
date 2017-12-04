package com.example.asus.quarterofanhourdemo.model.bean;

/**
 * 创建时间  2017/11/27 9:28
 * 创建人    gaozhijie
 * 类描述    段子的封装类
 */
public class CrosstalkBean{

    /**
     * content : 111
     * createTime : 2017-12-04T10:57:01
     * imgUrls : https://www.zhaoapi.cn/images/quarter/1512356221131raw.png|https://www.zhaoapi.cn/images/quarter/1512356221146image2349020171201.png
     * jid : 741
     * uid : 675
     * user : {"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512306825287image2017120311306.png","nickname":"zky","praiseNum":"null"}
     */

    private String content;
    private String createTime;
    private String imgUrls;
    private int jid;
    private int uid;
    private UserBean user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * fans : null
         * follow : null
         * icon : https://www.zhaoapi.cn/images/1512306825287image2017120311306.png
         * nickname : zky
         * praiseNum : null
         */

        private String fans;
        private String follow;
        private String icon;
        private String nickname;
        private String praiseNum;

        public String getFans() {
            return fans;
        }

        public void setFans(String fans) {
            this.fans = fans;
        }

        public String getFollow() {
            return follow;
        }

        public void setFollow(String follow) {
            this.follow = follow;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(String praiseNum) {
            this.praiseNum = praiseNum;
        }
    }
}
