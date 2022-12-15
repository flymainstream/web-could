package com.js.could.file.ceph;

import com.js.tools.verify.CheckForBasicLogic;
import lombok.Data;
import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*****
 * @Author:
 * @Description:
 ****/
@Data
@Configuration
@ConfigurationProperties(prefix = "ceph")
public class ContainerConfig {

    private String username;
    private String password;
    private String authUrl;
    private String defaultContainerName;


    /*****
     * 1、创建账号信息
     */
    @Bean
    public Account account() {
        checkSelf();
        AccountConfig config = new AccountConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setAuthUrl(authUrl);
        config.setAuthenticationMethod(AuthenticationMethod.BASIC);
        return new AccountFactory(config).createAccount();
    }


    /*****
     * 2、创建容器对象
     */
    @Bean
    public Container container() {
        return container(defaultContainerName);
    }

    private void checkSelf() {
        if (
                        !CheckForBasicLogic.ifNotNull(username)
                        ||
                        !CheckForBasicLogic.ifNotNull(password)
                        ||
                        !CheckForBasicLogic.ifNotNull(authUrl)
                        ||
                        !CheckForBasicLogic.ifNotNull(defaultContainerName)
        ) {

            throw new RuntimeException("can't read configuration");
        }
    }

    /*****
     *  创建容器对象
     */
    public Container container(String containerName) {
        checkSelf();
        Container container = account().getContainer(containerName);
        if (!container.exists()) {
            return container.create();
        }
        return container;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getDefaultContainerName() {
        return defaultContainerName;
    }

    public void setDefaultContainerName(String defaultContainerName) {
        this.defaultContainerName = defaultContainerName;
    }
}
