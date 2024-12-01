package club.siwoo.ytlivemc.display;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener {

    private String motd;

    @EventHandler
    public void onServerPing(ServerListPingEvent event) {
        motd = "&c&lSUBSCRIBE";

        event.setMotd(ChatColor.translateAlternateColorCodes('&', motd));
        event.setMaxPlayers(0);
    }
}
