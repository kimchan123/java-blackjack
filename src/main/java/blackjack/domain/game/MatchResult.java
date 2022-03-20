package blackjack.domain.game;

import blackjack.domain.participant.Player;

public enum MatchResult {

	BLACKJACK(1.5),
	WIN(1),
	LOSE(-1),
	DRAW(0);

	private final double leverage;

	MatchResult(double leverage) {
		this.leverage = leverage;
	}

	public static MatchResult compare(int standard, int opposite) {
		if (standard > opposite) {
			return MatchResult.WIN;
		}
		if (standard < opposite) {
			return MatchResult.LOSE;
		}
		return MatchResult.DRAW;
	}

	public double calculateRevenue(Player player) {
		return this.leverage * player.getBetMoney();
	}
}
