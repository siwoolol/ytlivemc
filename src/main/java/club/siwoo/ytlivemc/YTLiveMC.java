package club.siwoo.ytlivemc;

import club.siwoo.ytlivemc.display.MOTD;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class YTLiveMC extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Motd();
    }

    private void Motd() {
        getServer().getPluginManager().registerEvents(new MOTD(), this);
    }

    private void youtubeAPIReady() {
        //
    }
}
