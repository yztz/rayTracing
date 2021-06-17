package top.yzzblog.rayTracing.shape;

import top.yzzblog.rayTracing.HitRecord;
import top.yzzblog.rayTracing.Hittable;
import top.yzzblog.rayTracing.Ray;
import top.yzzblog.rayTracing.Vec3;
import top.yzzblog.rayTracing.material.Material;

public class XZRect implements Hittable {
    private float x0, x1, z0, z1, k;
    private Material material;


    public XZRect(float x0, float x1, float z0, float z1, float k,Material material) {
        this.x0 = x0;
        this.x1 = x1;
        this.z0 = z0;
        this.z1 = z1;
        this.k = k;

        this.material = material;
    }

    @Override
    public HitRecord hit(Ray r, float minT, float maxT) {
        HitRecord record = new HitRecord();
        float t = (k-r.origin().y())/r.direction().y();
        if(t < minT || t > maxT){
            return null;
        }
        float x = r.origin().x() + t*r.direction().x();
        float z = r.origin().z() + t*r.direction().z();
        if(x < x0 || x > x1 || z < z0 || z > z1){
            return null;
        }
//        record.u = (x-x0)/(x1-x0);
//        record.v = (y-y0)/(y1-y0);
        record.setT(t);
        record.setMaterial(material);
        record.setP(r.pointAtT(t));
        record.setNormal(new Vec3(0,1,0));

        return record;
    }

    public float getX0() {
        return x0;
    }

    public void setX0(float x0) {
        this.x0 = x0;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getZ0() {
        return z0;
    }

    public void setZ0(float z0) {
        this.z0 = z0;
    }

    public float getZ1() {
        return z1;
    }

    public void setZ1(float z1) {
        this.z1 = z1;
    }

    public float getK() {
        return k;
    }

    public void setK(float k) {
        this.k = k;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}