package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    public void setSide(int i) {
        this.mSide = i;
    }

    public void setPropagationSpeed(float f) {
        if (f != 0.0f) {
            this.mPropagationSpeed = f;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int i2;
        int i3;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i = -1;
        } else {
            transitionValues3 = transitionValues2;
            i = 1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i3 = epicenter.centerX();
            i2 = epicenter.centerY();
        } else {
            i3 = (round + width) / 2;
            i2 = (round2 + height) / 2;
        }
        float distance = ((float) distance(viewGroup, viewX, viewY, i3, i2, round, round2, width, height)) / ((float) getMaxDistance(viewGroup));
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return (long) Math.round((((float) (duration * ((long) i))) / this.mPropagationSpeed) * distance);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (androidx.core.view.ViewCompat.getLayoutDirection(r5) == 1) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r4 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (androidx.core.view.ViewCompat.getLayoutDirection(r5) == 1) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int distance(android.view.View r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        /*
            r4 = this;
            int r4 = r4.mSide
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r1 = 1
            r2 = 5
            r3 = 3
            if (r4 != r0) goto L_0x0014
            int r4 = androidx.core.view.ViewCompat.getLayoutDirection(r5)
            if (r4 != r1) goto L_0x0012
        L_0x0010:
            r4 = r2
            goto L_0x0020
        L_0x0012:
            r4 = r3
            goto L_0x0020
        L_0x0014:
            r0 = 8388613(0x800005, float:1.175495E-38)
            if (r4 != r0) goto L_0x0020
            int r4 = androidx.core.view.ViewCompat.getLayoutDirection(r5)
            if (r4 != r1) goto L_0x0010
            goto L_0x0012
        L_0x0020:
            if (r4 == r3) goto L_0x0046
            if (r4 == r2) goto L_0x003e
            r5 = 48
            if (r4 == r5) goto L_0x0036
            r5 = 80
            if (r4 == r5) goto L_0x002e
            r4 = 0
            goto L_0x004d
        L_0x002e:
            int r7 = r7 - r11
            int r8 = r8 - r6
            int r4 = java.lang.Math.abs(r8)
            int r4 = r4 + r7
            goto L_0x004d
        L_0x0036:
            int r13 = r13 - r7
            int r8 = r8 - r6
            int r4 = java.lang.Math.abs(r8)
            int r4 = r4 + r13
            goto L_0x004d
        L_0x003e:
            int r6 = r6 - r10
            int r9 = r9 - r7
            int r4 = java.lang.Math.abs(r9)
            int r4 = r4 + r6
            goto L_0x004d
        L_0x0046:
            int r12 = r12 - r6
            int r9 = r9 - r7
            int r4 = java.lang.Math.abs(r9)
            int r4 = r4 + r12
        L_0x004d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.distance(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i = this.mSide;
        if (i == 3 || i == 5 || i == 8388611 || i == 8388613) {
            return viewGroup.getWidth();
        }
        return viewGroup.getHeight();
    }
}
