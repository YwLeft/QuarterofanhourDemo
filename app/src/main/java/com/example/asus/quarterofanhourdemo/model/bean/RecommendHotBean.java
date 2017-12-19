package com.example.asus.quarterofanhourdemo.model.bean;

import java.util.List;

/**
 * 类描述    推荐——热门封装类
 */
public class RecommendHotBean {


    /**
     * commentNum : 0
     * comments : []
     * cover : https://www.zhaoapi.cn/images/quarter/1512722371193pp2.png
     * createTime : 2017-12-08T16:39:31
     * favoriteNum : 0
     * latitude : 40.040602
     * localUri : null
     * longitude : 116.300029
     * playNum : null
     * praiseNum : 0
     * uid : 2719
     * user : {"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512385050787image2017120418572919644.png","nickname":"123","praiseNum":"null"}
     * videoUrl : https://www.zhaoapi.cn/images/quarter/1512722371193cmhvideo.mp4
     * wid : 199
     * workDesc : 只是视频...
     */

    private int commentNum;
    private String cover;
    private String createTime;
    private int favoriteNum;
    private String latitude;
    private Object localUri;
    private String longitude;
    private Object playNum;
    private int praiseNum;
    private int uid;
    private UserBean user;
    private String videoUrl;
    private int wid;
    private String workDesc;
    private List<?> comments;

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(int favoriteNum) {
        this.favoriteNum = favoriteNum;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Object getLocalUri() {
        return localUri;
    }

    public void setLocalUri(Object localUri) {
        this.localUri = localUri;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Object getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Object playNum) {
        this.playNum = playNum;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public List<?> getComments() {
        return comments;
    }

    public void setComments(List<?> comments) {
        this.comments = comments;
    }

    public static class UserBean {
        /**
         * age : null
         * fans : null
         * follow : null
         * icon : https://www.zhaoapi.cn/images/1512385050787image2017120418572919644.png
         * nickname : 123
         * praiseNum : null
         */

        private Object age;
        private String fans;
        private String follow;
        private String icon;
        private String nickname;
        private String praiseNum;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

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
