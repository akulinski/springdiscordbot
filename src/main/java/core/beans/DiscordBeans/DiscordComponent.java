package core.beans.DiscordBeans;

import core.beans.Events.discord.Listeners.ReadyListener;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Component
@PropertySource( "classpath:application.properties")

public class DiscordComponent {

    private JDA jda;

    public String getToken() {
        return token;
    }

    @Value(value = "${dc.token}")
    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    @PostConstruct
    public void init() {
        try {
            System.out.println("TOKEN: "+token);
            jda = new JDABuilder(token).addEventListener(new ReadyListener()).build();
            jda.awaitReady();
        } catch (InterruptedException | LoginException e) {
            System.out.println("Shitty token");
            e.printStackTrace();
        }
    }
}
