/**
  * Copyright 2020 bejson.com 
  */
package com.bejson.pojo;

/**
 * Auto-generated: 2020-06-16 20:28:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Face_list {

    private String face_token;
    private Location location;
    private int face_probability;
    private Angle angle;
    private int age;
    private double beauty;
    private Gender gender;
    private Emotion emotion;
    private Mask mask;
    private double spoofing;
    public void setFace_token(String face_token) {
         this.face_token = face_token;
     }
     public String getFace_token() {
         return face_token;
     }

    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setFace_probability(int face_probability) {
         this.face_probability = face_probability;
     }
     public int getFace_probability() {
         return face_probability;
     }

    public void setAngle(Angle angle) {
         this.angle = angle;
     }
     public Angle getAngle() {
         return angle;
     }

    public void setAge(int age) {
         this.age = age;
     }
     public int getAge() {
         return age;
     }

    public void setBeauty(double beauty) {
         this.beauty = beauty;
     }
     public double getBeauty() {
         return beauty;
     }

    public void setGender(Gender gender) {
         this.gender = gender;
     }
     public Gender getGender() {
         return gender;
     }

    public void setEmotion(Emotion emotion) {
         this.emotion = emotion;
     }
     public Emotion getEmotion() {
         return emotion;
     }

    public void setMask(Mask mask) {
         this.mask = mask;
     }
     public Mask getMask() {
         return mask;
     }

    public void setSpoofing(double spoofing) {
         this.spoofing = spoofing;
     }
     public double getSpoofing() {
         return spoofing;
     }

}