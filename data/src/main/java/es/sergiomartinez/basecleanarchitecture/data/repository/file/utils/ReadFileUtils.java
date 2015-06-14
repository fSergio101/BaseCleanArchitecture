package es.sergiomartinez.basecleanarchitecture.data.repository.file.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class ReadFileUtils {

  public static String readDataFromAssets(String file, Context context) {
    try {
      InputStream is = context.getAssets().open(file);
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      StringBuilder builder = new StringBuilder();

      String line = null;
      try {
        while ((line = reader.readLine()) != null) {
          builder.append(line);
          // builder.append("\n"); // append a new line
        }
      } catch (IOException e) {

        e.printStackTrace();
      } finally {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      return builder.toString();

    } catch (IOException e) {

      e.printStackTrace();
    }
    return null;
  }

}
