package ru.ifmo.hycson.demoapp.data;

import com.github.scribejava.apis.VkontakteApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

import dagger.Module;
import dagger.Provides;
import ru.ifmo.hycson.demoapp.BuildConfig;
import ru.ifmo.hycson.demoapp.util.LogHelper;

@Module
public class OAuthModule {

    @Provides
    OAuth20Service provideVKOAuth20Service() {
        LogHelper.d(LogHelper.TAG_MODULE, this.getClass().getSimpleName() + ".provideVKOAuth20Service");
        return new ServiceBuilder()
                .apiKey(BuildConfig.VK_API_KEY)
                .apiSecret(BuildConfig.VK_API_SECRET)
                .callback(BuildConfig.VK_API_CALLBACK_URI)
                .scope("wall,friends")
                .build(VkontakteApi.instance());
    }
}
