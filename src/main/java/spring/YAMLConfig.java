package spring;

import org.springframework.beans.factory.annotation.Value;

public class YAMLConfig {

    @Value("${variable}")
    private String variable;
    @Value("${name}")
    private String name;
    @Value("${environment}")
    private String environment;
    @Value("${enabled}")
    private boolean enabled;
    @Value("${servers}")
    String[] servers;

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String[] getServers() {
        return servers;
    }

    public void setServers(String[] servers) {
        this.servers = servers;
    }
}

