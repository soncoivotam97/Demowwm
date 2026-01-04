package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReportQueue$$ExternalSyntheticLambda1 implements TransportScheduleCallback {
    public final /* synthetic */ ReportQueue f$0;
    public final /* synthetic */ TaskCompletionSource f$1;
    public final /* synthetic */ CrashlyticsReportWithSessionId f$2;

    public /* synthetic */ ReportQueue$$ExternalSyntheticLambda1(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f$0 = reportQueue;
        this.f$1 = taskCompletionSource;
        this.f$2 = crashlyticsReportWithSessionId;
    }

    public final void onSchedule(Exception exc) {
        this.f$0.m173lambda$sendReport$1$comgooglefirebasecrashlyticsinternalsendReportQueue(this.f$1, this.f$2, exc);
    }
}
