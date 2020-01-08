package Foundation.utils;

import org.openqa.selenium.BuildInfo;

public class BuildInformation {
    private static BuildInfo info;

    public static String getBuildInfo(){
        if(info == null){
            info = new BuildInfo();
        }
        return info.getBuildRevision();

    }

    public static String getBuildReleaseLabel(){
        if(info == null){
            info = new BuildInfo();
        }
        return info.getReleaseLabel();

    }
}
