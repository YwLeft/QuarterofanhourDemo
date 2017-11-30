package com.example.asus.quarterofanhourdemo.model.bean;

import java.util.List;

/**
 * 创建时间  2017/11/27 9:28
 * 创建人    gaozhijie
 * 类描述    段子的封装类
 */
public class CrosstalkBean{

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"节目","createTime":"2017-11-29T18:57:50","imgUrls":null,"jid":217,"praiseNum":null,"shareNum":null,"uid":144,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/144.jpg","nickname":"乔君","praiseNum":"null"}},{"commentNum":null,"content":"sdfdsfds","createTime":"2017-11-29T18:57:09","imgUrls":null,"jid":216,"praiseNum":null,"shareNum":null,"uid":3025,"user":{"age":null,"fans":"null","follow":"null","icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"456","createTime":"2017-11-29T18:55:37","imgUrls":null,"jid":215,"praiseNum":null,"shareNum":null,"uid":142,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/142.jpg","nickname":"fghg","praiseNum":"null"}},{"commentNum":null,"content":"123456","createTime":"2017-11-29T18:50:16","imgUrls":null,"jid":214,"praiseNum":null,"shareNum":null,"uid":2750,"user":{"age":null,"fans":"null","follow":"null","icon":null,"nickname":"%E6%9F%92%E7%83%81","praiseNum":"null"}},{"commentNum":null,"content":"大家好，我是萌新","createTime":"2017-11-29T18:33:04","imgUrls":null,"jid":213,"praiseNum":null,"shareNum":null,"uid":100,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/100.jpg","nickname":"节能君","praiseNum":"null"}},{"commentNum":null,"content":"6666","createTime":"2017-11-29T18:12:56","imgUrls":null,"jid":212,"praiseNum":null,"shareNum":null,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"李灿灿","praiseNum":"null"}},{"commentNum":null,"content":"做个迷人的混蛋\n善良并没有喜感","createTime":"2017-11-29T18:05:44","imgUrls":null,"jid":211,"praiseNum":null,"shareNum":null,"uid":114,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/114.jpg","nickname":"Bount","praiseNum":"null"}},{"commentNum":null,"content":"有一朋友名叫王根基，某天第一次去见女友爸女友爸爸：\u201c你是小王吧！\u201d想想又觉得不对，连忙改口道：\u201c你是小基吧！\u201d眼看气氛变得越来越尴尬，女友妈妈连忙出来打圆场，\u201c你就是根基吧！\u201d","createTime":"2017-11-29T16:19:06","imgUrls":null,"jid":210,"praiseNum":null,"shareNum":null,"uid":86,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/86.jpg","nickname":"GUODONG","praiseNum":"null"}},{"commentNum":null,"content":"分享一个#内涵段子#: 出差一个月提前回家没有告诉老婆，到家的时候，听见卧室里有动静，我二话没说就冲进去了，可是屋里只有老婆一个人，老婆吃惊的看着我说：\u201c老。。老公，你。你怎么回来了\u201d我看了看床底，看了看衣柜，什么都没有，可能是我听错了吧\u2026\u2026","createTime":"2017-11-29T16:12:29","imgUrls":null,"jid":209,"praiseNum":null,"shareNum":null,"uid":99,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/99.jpg","nickname":"Zhu","praiseNum":"null"}},{"commentNum":null,"content":"公交车上，一个40岁左右的男子拉着一个十一二岁的小女孩，小女孩说：王校长，我想吃圣代。这时全车人的目光都集中在了那男子身上，甚至有人都掏出手机准备拍照或拨打110，这时候该男子尴尬的对小女孩说：你个熊孩子，在学校叫校长，出来还是叫爸爸吧。","createTime":"2017-11-29T16:09:15","imgUrls":null,"jid":208,"praiseNum":null,"shareNum":null,"uid":98,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/98.jpg","nickname":"Mo","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 节目
         * createTime : 2017-11-29T18:57:50
         * imgUrls : null
         * jid : 217
         * praiseNum : null
         * shareNum : null
         * uid : 144
         * user : {"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/144.jpg","nickname":"乔君","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

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

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
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
             * age : null
             * fans : null
             * follow : null
             * icon : https://www.zhaoapi.cn/images/144.jpg
             * nickname : 乔君
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
}