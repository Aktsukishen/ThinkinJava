package com.chapter19.learning.l_1910_s;

public enum RoShamBo4 implements Competitor<RoShamBo4>{
	
	ROCK{
		@Override
		public Outcome compete(RoShamBo4 opponent) {
			return compete(SCISSORS,opponent);
		}
		
	},
	SCISSORS{
		@Override
		public Outcome compete(RoShamBo4 opponent) {
			return compete(PAPER,opponent);
		}
	},
	PAPER{
		@Override
		public Outcome compete(RoShamBo4 opponent) {
			return compete(ROCK,opponent);
		}
	};
	Outcome compete(RoShamBo4 loser,RoShamBo4 oppoent){
		return ((oppoent==this)? Outcome.DRAW
			   :(oppoent==loser?Outcome.WIN:Outcome.LOSE));
	}
}
