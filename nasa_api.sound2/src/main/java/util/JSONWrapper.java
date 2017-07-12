package util;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JSONWrapper {

    private JSONArray jsonArray;
    private JSONObject jsonObj;

  

    public JSONWrapper(JSONArray array)
    {
        this.jsonArray = array;
    }
    public JSONWrapper(JSONObject obj)
    {
         this.jsonObj = obj;
    }


    public boolean isKeyAvailable(String mKey)
    {
        boolean available = false;
        Iterator<?> jsonKeys =jsonObj.keys();
        while (jsonKeys.hasNext()) {
            String key = (String)jsonKeys.next();
            if (key.equals(mKey)) {
                available = true;
                break;
            }

        }
        return available;

    }

    public boolean isValueNotNull(String mKey) {
        try {
            boolean isNull = jsonObj.get(mKey).toString() != null ? true : false;
            return isNull;
        } catch (JSONException e) {
            e.printStackTrace();;
        }
        return true;
    }

    public String getJsonValue(String mKey)
    {
        String value = null;
        try {
            value = jsonObj.get(mKey).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public int getJsonIntValue(String mKey) {
        int intValue = 0;
        String value = null;
        try {
            value = jsonObj.get(mKey).toString();
            if (!StringUtils.isNumeric(value)) {
                return 0;
            } else {
                intValue = Integer.parseInt(value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return intValue;
    }

    public boolean getJsonBooleanVal(String mKey) {
        boolean boolValue = true;
        String value = null;
        try {
            value = jsonObj.get(mKey).toString();
            boolValue = Boolean.valueOf(value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return boolValue;
    }


    public JSONObject getJsonObject(String mKey)
    {
        Object json;
        //JSONArray array = null;
        try {
            json = jsonObj.get(mKey);
            if(json != null && (json instanceof JSONObject))
            {
                return (JSONObject)json;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public JSONArray getJsonArray(String mKey)
    {
        Object json;
        try {
            json = jsonObj.get(mKey);
            if(json != null && (json instanceof JSONArray))
            {
               return (JSONArray)json;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void getJsonArrayObject(int index)
    {
        try {
            this.jsonObj = (JSONObject)jsonArray.get(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isPropertyArray(String mKey)
    {
        boolean isArray = false;
        Object obj = null;
        try {
            obj = jsonObj.get(mKey);
            if(obj != null && obj instanceof JSONArray)
            {
                isArray = true;
                this.jsonArray = (JSONArray)obj;
            }
        } catch (JSONException e) {
            e.printStackTrace();;
        }

        return isArray;
    }

    public String getJsonArrayElement(String mKey,int index)
    {
        String value = null;
        Object obj = null;
        JSONArray array;
        try {
            obj = jsonObj.get(mKey);
            if(obj == null || !(obj instanceof JSONArray))
            {
                return null;
            }
            else
            {
                array = (JSONArray)obj;
                value = getElement(array,index);
               // value = (String)array.get(index);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void getArrayChildObject(int index)
    {
        Object obj = null;
        try {
            if (jsonArray != null && jsonArray.length() > 0) {
                obj = jsonArray.get(index);
                if (obj instanceof JSONObject)
                {
                    this.jsonObj = (JSONObject)obj;
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
    public String getElement(JSONArray array , int index)
    {
        try {
            return (String)array.get(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

   
     

    public int getPropertyCount()
    {
       return jsonObj.length();
    }
    public int getArrayCount() {
        return jsonArray.length();
    }
}
