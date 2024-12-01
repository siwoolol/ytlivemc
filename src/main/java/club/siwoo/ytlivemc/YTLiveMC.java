package club.siwoo.ytlivemc;

import club.siwoo.ytlivemc.display.MOTD;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class YTLiveMC extends JavaPlugin implements Listener {

    private YTLiveMC plugin;

    private FileConfiguration youtubeConfig;
    private File youtubeFile;

    public YTLiveMC(YTLiveMC plugin) {
        this.plugin = plugin;
        createYoutubeFile();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public void onEnable() {
        Motd();
        createYoutubeFile();
        youtubeAPIReady();
    }

    @Override
    public void onDisable() {
        saveYoutubeFile();
    }

    private void Motd() {
        getServer().getPluginManager().registerEvents(new MOTD(), this);
    }

    private void createYoutubeFile() {
        youtubeFile = new File(plugin.getDataFolder(), "youtube.yml");
        if (!youtubeFile.exists()) {
            try {
                youtubeFile.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create youtube.yml!");
            }
        }
        youtubeConfig = YamlConfiguration.loadConfiguration(youtubeFile);
    }

    private void saveYoutubeFile() {
        try {
            youtubeConfig.save(youtubeFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save youtube.yml!");
        }
    }

    private static void youtubeAPIReady() {
        String apiKey = "API_KEY";

        try {
            YouTube youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                    .setApplicationName("YTLiveMC")
                    .build();
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
