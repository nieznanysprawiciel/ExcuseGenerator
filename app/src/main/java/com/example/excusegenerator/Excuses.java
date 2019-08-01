package com.example.excusegenerator;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Excuses
{
    private List< String >      mPart1;
    private List< String >      mPart2;
    private List< String >      mPart3;

    int idx = 0;

    public String Generate()
    {
        return GenerateImpl( mPart1, mPart2, mPart3 );
    }

    public void LoadSegments( Context context )
    {
        mPart1 = LoadSegment( context, R.raw.part1_strings );
        mPart2 = LoadSegment( context, R.raw.part2_strings );
        mPart3 = LoadSegment( context, R.raw.part3_strings );
    }

    private String GenerateImpl( List< String > part1, List< String > part2, List< String > part3 )
    {
//        String[] examples = {"Text 1", "Text 2", "Text 3"};
//        idx = (idx + 1) % examples.length;
//        return examples[ idx ];
        return part1.get(0) + part2.get(0) + part3.get(0);
    }

    private List< String > LoadSegment( Context context, int id )
    {
        InputStream stream = context.getResources().openRawResource( id );
        BufferedReader r = new BufferedReader( new InputStreamReader( stream ) );

        List< String > results = new ArrayList< String >();

        try
        {
            String line;
            while( (line = r.readLine()) != null )
            {
                results.add( line );
            }
        }
        catch( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return results;
    }
}
