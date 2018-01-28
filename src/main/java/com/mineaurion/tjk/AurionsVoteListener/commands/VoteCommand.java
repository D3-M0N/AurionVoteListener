package com.mineaurion.tjk.AurionsVoteListener.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

import com.mineaurion.tjk.AurionsVoteListener.AurionsVoteListener;

public class VoteCommand implements CommandExecutor {

	@SuppressWarnings("static-access")
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		if (src.hasPermission("*") || src.hasPermission("listener.user.vote")) {
			AurionsVoteListener plugin = new AurionsVoteListener();
			if (plugin.votecommand) {
				for (int i = 0; i < plugin.voteMessage.size(); i++) {
					src.sendMessage(plugin.formatmessage(plugin.voteMessage.get(i), "", src.getName()));
				}
			}
			return CommandResult.success();
		} else {
			src.sendMessage(Text.of("You don't have permission"));
			return CommandResult.empty();
		}
	}

}
