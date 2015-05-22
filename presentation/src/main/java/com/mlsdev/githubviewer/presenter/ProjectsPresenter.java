package com.mlsdev.githubviewer.presenter;

/**
 * Created by roma on 22.05.15.
 */
public interface ProjectsPresenter {
    /**
     * Created by roma on 20.05.15.
     */
    class User {

        private String name;
        private String icon;
        private int followers;
        private int following;

        public String getName() {
            return name;
        }

        public String getIcon() {
            return icon;
        }

        public int getFollowers() {
            return followers;
        }

        public int getFollowing() {
            return following;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public void setFollowing(int following) {
            this.following = following;
        }
    }
}
