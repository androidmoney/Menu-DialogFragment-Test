Menu-DialogFragment-Test
========================

Project demonstrating bug when displaying a DialogFragment from a popup menu.

If displaying the Dialog Fragment using the on-screen button, pausing/resuming the app works as expected.

But if the dialog fragment is displayed via the Menu Item (must be a pop-up menu), the dialog fragment disappears after a resume.

The dialog can be mde to "stick" if you wrap the display of the fragment into a Handler set to about 300ms delay. Anything less, including no delay, still fails.

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    showDialogFragment();
                }
            }, 300);
