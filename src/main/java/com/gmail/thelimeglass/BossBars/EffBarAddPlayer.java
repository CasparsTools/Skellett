package com.gmail.thelimeglass.BossBars;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffBarAddPlayer extends Effect {
	
	//[skellett] add %player% to [the] [boss[ ]]bar %bossbar%
	
	private Expression<Player> player;
	private Expression<BossBar> bar;
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] e, int arg1, Kleenean arg2, ParseResult arg3) {
		player = (Expression<Player>) e[0];
		bar = (Expression<BossBar>) e[1];
		return true;
	}
	@Override
	public String toString(@Nullable Event paramEvent, boolean paramBoolean) {
		return "[skellett] add %player% to [the] [boss[ ]]bar %bossbar%";
	}
	@Override
	protected void execute(Event e) {
		if (bar == null) {
			return;
		}
		bar.getSingle(e).addPlayer(player.getSingle(e));
	}
}