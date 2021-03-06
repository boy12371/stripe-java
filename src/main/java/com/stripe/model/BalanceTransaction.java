package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.List;
import java.util.Map;

public class BalanceTransaction extends APIResource implements HasId {
	String id;
	Integer amount;
	Long availableOn;
	Long created;
	String currency;
	String description;
	Integer fee;
	List<Fee> feeDetails;
	Integer net;
	String source;
	TransferCollection sourcedTransfers;
	String status;
	String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Long getAvailableOn() {
		return availableOn;
	}

	public void setAvailableOn(Long availableOn) {
		this.availableOn = availableOn;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public List<Fee> getFeeDetails() {
		return feeDetails;
	}

	public void setFeeDetails(List<Fee> feeDetails) {
		this.feeDetails = feeDetails;
	}

	public Integer getNet() {
		return net;
	}

	public void setNet(Integer net) {
		this.net = net;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public TransferCollection getSourcedTransfers() {
		if (sourcedTransfers != null && sourcedTransfers.getURL() == null && getSource() != null) {
			sourcedTransfers.setURL(String.format("/v1/transfers?source_transaction=%s", getSource()));
		}
		return sourcedTransfers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static BalanceTransaction retrieve(String id) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return retrieve(id, (RequestOptions) null);
	}

	@Deprecated
	public static BalanceTransaction retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		String url = String.format("%s/%s/%s", Stripe.getApiBase(), "v1/balance/history", id);
		return retrieve(id, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public static BalanceTransaction retrieve(String id, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		String url = String.format("%s/%s/%s", Stripe.getApiBase(), "v1/balance/history", id);
		return request(RequestMethod.GET, url, null, BalanceTransaction.class, options);
	}

	public static BalanceTransactionCollection list(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	public static BalanceTransactionCollection list(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		String url = String.format("%s/%s", Stripe.getApiBase(), "v1/balance/history");
		return requestCollection(url, params, BalanceTransactionCollection.class, options);
	}

	@Deprecated
	public static BalanceTransactionCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	@Deprecated
	public static BalanceTransactionCollection all(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public static BalanceTransactionCollection all(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, options);
	}
}
