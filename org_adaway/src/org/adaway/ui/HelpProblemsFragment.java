/*
 * Copyright (C) 2011 Dominik Schürmann <dominik@dominikschuermann.de>
 *
 * This file is part of AdAway.
 * 
 * AdAway is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AdAway is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AdAway.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.adaway.ui;

import org.adaway.R;
import org.adaway.util.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HelpProblemsFragment extends Fragment {
    Activity mActivity;
    TextView mHelpText;

    /**
     * Inflate the layout for this fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        mActivity = getActivity();

        final View view = inflater.inflate(R.layout.help_fragment, container, false);

        mHelpText = (TextView) view.findViewById(R.id.help_fragment_text);

        // load html from html file from /res/raw
        String helpText = Utils.readContentFromResource(mActivity, R.raw.help_problems);

        // set text from resources with html markup
        mHelpText.setText(Html.fromHtml(helpText));
        // make links work
        mHelpText.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}