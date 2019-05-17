package com.example.core.realm;

import android.util.Log;

import io.realm.Realm;

public class CoreRealmDataSourse {

    protected Realm getRealmInStance() {
        return Realm.getDefaultInstance();
    }

    protected void executeTransanction(Realm.Transaction transaction) {
        Realm realm = null;

        try {
            realm = getRealmInStance();
            realm.executeTransactionAsync(transaction);
        }catch (Exception e) {
            Log.d("ololo", e.getMessage(),e);
            //TODO: LOg
        } finally {
            if ( realm != null) {
                realm.close();
            }
        }
    }

    protected long getNextId(Class c) {
        Realm realm = null;
        try {
            realm = getRealmInStance();
            String primaryKeyField = realm.getSchema()
                    .get(c.getSimpleName())
                    .getPrimaryKey();

            if ( realm.where(c).max(primaryKeyField) == null) {
                return 1;
            }

            int value = realm.where(c).max(primaryKeyField).intValue();
            return  value + 1;
        }catch (Exception e) {
            Log.d("ololo", e.getMessage(),e);
            return -1;
            //TODO: LOg
        } finally {
            if ( realm != null) {
                realm.close();
            }
        }
    }
}
