package model;

public class SiteEVLogic {
	public void like(SiteEV site) {
		int count = site.getLike();  // likeの数
		site.setLike(count + 1);     // count+1にして更新
	}
	
	public void dislike(SiteEV site) {
		int count = site.getDislike();
		site.setDislike(count + 1);
	}
}
