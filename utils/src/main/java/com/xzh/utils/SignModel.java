package com.xzh.utils;



public class SignModel {
    //    Variant: debug
    //    Config: debug
    //    Store: /home/xzh/.android/androidbase.jks
    //    Alias: key0
    //    MD5: BA:82:00:FB:9E:8E:F5:B4:2E:90:B4:AF:37:65:9F:BE
    //    SHA1: B3:75:78:3C:AF:B2:99:23:B5:2C:A1:F0:F3:52:45:A3:11:69:04:24
    //    SHA-256: C4:78:C9:B5:0A:58:EA:59:F7:31:07:A6:5C:94:4A:34:10:95:70:CB:B2:D6:E9:D2:63:E9:9E:DD:F8:13:7C:BF
    //    Valid until: 2046年10月6日 星期六
    private String variant;
    private String config;
    private String store;
    private String alias;
    private String md5;
    private String sha1;
    private String sha256;
    private String validUntil;

    public SignModel(String variant, String config, String store, String alias, String md5, String sha1, String sha256, String validUntil) {
        this.variant = variant;
        this.config = config;
        this.store = store;
        this.alias = alias;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
        this.validUntil = validUntil;
    }

    public SignModel() {
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "SignModel{" +
                "variant='" + variant + '\'' +
                ", config='" + config + '\'' +
                ", store='" + store + '\'' +
                ", alias='" + alias + '\'' +
                ", md5='" + md5 + '\'' +
                ", sha1='" + sha1 + '\'' +
                ", sha256='" + sha256 + '\'' +
                ", validUntil='" + validUntil + '\'' +
                '}';
    }
}
