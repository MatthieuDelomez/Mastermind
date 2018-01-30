package com.sdz.observation;

import com.sdz.admin.Score;

public interface Observer {
	
	public void update(int code, int pts, int nbreCode);
	public void restart(int word);
	public void showsScore(Score[] list);
	public void accueil();
	


}
