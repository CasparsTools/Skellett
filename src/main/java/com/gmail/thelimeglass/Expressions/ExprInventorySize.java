package com.gmail.thelimeglass.Expressions;

import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.eclipse.jdt.annotation.Nullable;

import com.gmail.thelimeglass.Utils.Annotations.Config;
import com.gmail.thelimeglass.Utils.Annotations.PropertyType;
import com.gmail.thelimeglass.Utils.Annotations.Syntax;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

@Syntax({"[skellett] (gui|menu|inventory|chest|window) (size|number|slots) (of|from) %inventory%", "%inventory%'s (gui|menu|inventory|chest|window) (size|number|slots)"})
@Config("SizeOfInventory")
@PropertyType(ExpressionType.COMBINED)
public class ExprInventorySize extends SimpleExpression<Number>{
	
	private Expression<Inventory> inventory;
	@Override
	public Class<? extends Number> getReturnType() {
		return Number.class;
	}
	@Override
	public boolean isSingle() {
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] e, int arg1, Kleenean arg2, ParseResult arg3) {
		inventory = (Expression<Inventory>) e[0];
		return true;
	}
	@Override
	public String toString(@Nullable Event e, boolean arg1) {
		return "inventory size";
	}
	@Override
	@Nullable
	protected Number[] get(Event e) {
		return new Number[]{(inventory.getSingle(e)).getSize()};
	}
}