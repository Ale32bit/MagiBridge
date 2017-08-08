package com.magitechserver.magibridge.util;

import org.spongepowered.api.Platform;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.permission.PermissionService;
import org.spongepowered.api.service.permission.Subject;


/**
 * Created by Frani on 20/07/2017.
 */
public class GroupUtil {

    public static String getHighestGroup(Player player){
        if(Sponge.getPlatform().getContainer(Platform.Component.API).getVersion().orElse("").contains("7.0.0")) return "";
        if(!Sponge.getGame().getServiceManager().getRegistration(PermissionService.class).isPresent()) return "";
        PermissionService ps = Sponge.getGame().getServiceManager().getRegistration(PermissionService.class).get().getProvider();
        for (Subject sub : player.getParents()) {
            if (sub.getContainingCollection().equals(ps.getGroupSubjects())) {
                return sub.getIdentifier();
            }
        }
        return "";
    }

}
