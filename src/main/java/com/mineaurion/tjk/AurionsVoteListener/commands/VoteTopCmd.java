package com.mineaurion.tjk.AurionsVoteListener.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

import com.mineaurion.tjk.AurionsVoteListener.AurionsVoteListener;
import com.mineaurion.tjk.AurionsVoteListener.SwitchSQL;

public class VoteTopCmd implements CommandExecutor {

	@SuppressWarnings("static-access")
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		if (src.hasPermission("*") || src.hasPermission("listener.user.votetop")) {
			AurionsVoteListener plugin = new AurionsVoteListener();

			for (int i = 0; i < plugin.votetopheader.size(); i++) {
				src.sendMessage(plugin.formatmessage(plugin.votetopheader.get(i), "", src.getName()));
			}
			SwitchSQL.VoteTop(src);
			return CommandResult.success();
		} else {
			src.sendMessage(Text.of("You don't have permission"));
			return CommandResult.empty();
		}
	}
}
