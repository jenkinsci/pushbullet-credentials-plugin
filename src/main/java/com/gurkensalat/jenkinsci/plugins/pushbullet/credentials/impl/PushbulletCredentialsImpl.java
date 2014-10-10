package com.gurkensalat.jenkinsci.plugins.pushbullet.credentials.impl;

import com.cloudbees.plugins.credentials.CredentialsDescriptor;
import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import com.gurkensalat.jenkinsci.plugins.pushbullet.credentials.PushbulletCredentials;
import hudson.Extension;
import hudson.util.Secret;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class PushbulletCredentialsImpl extends BaseStandardCredentials implements PushbulletCredentials
{
    @Nonnull
    private final Secret secret;

    @Nonnull
    private final String apiKey;

    @DataBoundConstructor
    public PushbulletCredentialsImpl(@CheckForNull CredentialsScope scope, @CheckForNull String id,
                                     @Nonnull String apiKey, @Nonnull Secret secret, @CheckForNull String description)
    {
        super(scope, id, description);
        this.apiKey = apiKey;
        this.secret = secret;
    }

    public Secret getSecret()
    {
        return secret;
    }

    @Extension
    public static class DescriptorImpl extends CredentialsDescriptor
    {
        @Override
        public String getDisplayName()
        {
            return Messages.PushbulletCredentialsImpl_DisplayName();
        }
    }
}
