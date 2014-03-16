package br.com.wfcreations.craftduino;

public class ModInfo {

    public static final String MOD_ID = "craftduino";
    public static final String MOD_NAME = "CraftDuino";
    public static final String TEXTURE_LOCATION = MOD_ID + ":";
    public static final int VERSION_MAJOR = 0;
    public static final int VERSION_MINOR = 0;
    public static final int VERSION_PATCH = 0;
    public static final String VERSION = VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH + "dev";
    public static final String CHANNEL_NAME = MOD_ID;
    public static final String DEPENDENCIES = "required-after:Forge@[9.11.1.965,);required-after:ComputerCraft";
    public static final String COMMON_PROXY_CLASS = "br.com.wfcreations.craftduino.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "br.com.wfcreations.craftduino.proxy.ClientProxy";
    
}
