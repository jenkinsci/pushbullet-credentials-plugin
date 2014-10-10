package com.gurkensalat.jenkinsci.plugins.pushbullet.credentials;

import com.cloudbees.plugins.credentials.CredentialsNameProvider;
import com.cloudbees.plugins.credentials.NameWith;
import com.cloudbees.plugins.credentials.common.StandardCredentials;
import hudson.util.Secret;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nonnull;

@NameWith(PushbulletCredentials.NameProvider.class)
public interface PushbulletCredentials extends StandardCredentials
{
    @Nonnull
    Secret getSecret();

    class NameProvider extends CredentialsNameProvider<PushbulletCredentials>
    {
        @Override
        public String getName(PushbulletCredentials c)
        {
            String description = StringUtils.stripToEmpty(c.getDescription());
            return Messages.PushbulletCredentials_name_prefix() + (description != null ? " (" + description + ")" : "");
        }
    }
}
