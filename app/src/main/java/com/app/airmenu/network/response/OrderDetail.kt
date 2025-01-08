package com.app.airmenu.network.response


import com.google.gson.annotations.SerializedName

class OrderDetail(
    @SerializedName("brand")
    val brand: String,
    @SerializedName("cart")
    val cart: Cart,
    @SerializedName("current_state")
    val currentState: String,
    @SerializedName("display_id")
    val displayId: String,
    @SerializedName("eater")
    val eater: Eater,
    @SerializedName("eaters")
    val eaters: List<Eaters>,
    @SerializedName("estimated_ready_for_pickup_at")
    val estimatedReadyForPickupAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("packaging")
    val packaging: Packaging,
    @SerializedName("payment")
    val payment: Payment,
    @SerializedName("placed_at")
    val placedAt: String,
    @SerializedName("store")
    val store: Store,
    @SerializedName("type")
    val type: String
) {
    class Cart(
        @SerializedName("fulfillment_issues")
        val fulfillmentIssues: List<Any>,
        @SerializedName("items")
        val items: List<Item>,
        @SerializedName("version_id")
        val versionId: String,
        @SerializedName("special_instructions")
        val instructions: String
    ) {

        class Item(
            @SerializedName("eater_id")
            val eaterId: String,
            @SerializedName("external_data")
            val externalData: String,
            @SerializedName("id")
            val id: String,
            @SerializedName("instance_id")
            val instanceId: String,
            @SerializedName("price")
            val price: Price,
            @SerializedName("quantity")
            val quantity: Int,
            @SerializedName("selected_modifier_groups")
            val selectedModifierGroups: List<SelectedModifierGroup>,
            @SerializedName("title")
            val title: String,
            @SerializedName("special_instructions")
            val instructions: String
        ) {

            class Price(
                @SerializedName("base_total_price")
                val baseTotalPrice: BaseTotalPrice,
                @SerializedName("base_unit_price")
                val baseUnitPrice: BaseUnitPrice,
                @SerializedName("total_price")
                val totalPrice: TotalPrice,
                @SerializedName("unit_price")
                val unitPrice: UnitPrice
            ) {

                class BaseTotalPrice(
                    @SerializedName("amount")
                    val amount: Int,
                    @SerializedName("currency_code")
                    val currencyCode: String,
                    @SerializedName("formatted_amount")
                    val formattedAmount: String
                )

                class BaseUnitPrice(
                    @SerializedName("amount")
                    val amount: Int,
                    @SerializedName("currency_code")
                    val currencyCode: String,
                    @SerializedName("formatted_amount")
                    val formattedAmount: String
                )

                class TotalPrice(
                    @SerializedName("amount")
                    val amount: Int,
                    @SerializedName("currency_code")
                    val currencyCode: String,
                    @SerializedName("formatted_amount")
                    val formattedAmount: String
                )

                class UnitPrice(
                    @SerializedName("amount")
                    val amount: Int,
                    @SerializedName("currency_code")
                    val currencyCode: String,
                    @SerializedName("formatted_amount")
                    val formattedAmount: String
                )
            }

            class SelectedModifierGroup(
                @SerializedName("external_data")
                val externalData: String,
                @SerializedName("id")
                val id: String,
                @SerializedName("removed_items")
                val removedItems: Any,
                @SerializedName("selected_items")
                val selectedItems: List<SelectedItem>,
                @SerializedName("title")
                val title: String
            ) {

                class SelectedItem(
                    @SerializedName("default_quantity")
                    val defaultQuantity: Int,
                    @SerializedName("external_data")
                    val externalData: String,
                    @SerializedName("id")
                    val id: String,
                    @SerializedName("price")
                    val price: Price,
                    @SerializedName("quantity")
                    val quantity: Int,
                    @SerializedName("selected_modifier_groups")
                    val selectedModifierGroups: Any,
                    @SerializedName("title")
                    val title: String
                ) {

                    class Price(
                        @SerializedName("base_total_price")
                        val baseTotalPrice: BaseTotalPrice,
                        @SerializedName("base_unit_price")
                        val baseUnitPrice: BaseUnitPrice,
                        @SerializedName("total_price")
                        val totalPrice: TotalPrice,
                        @SerializedName("unit_price")
                        val unitPrice: UnitPrice
                    ) {
                        class BaseTotalPrice(
                            @SerializedName("amount")
                            val amount: Int,
                            @SerializedName("currency_code")
                            val currencyCode: String,
                            @SerializedName("formatted_amount")
                            val formattedAmount: String
                        )

                        class BaseUnitPrice(
                            @SerializedName("amount")
                            val amount: Int,
                            @SerializedName("currency_code")
                            val currencyCode: String,
                            @SerializedName("formatted_amount")
                            val formattedAmount: String
                        )

                        class TotalPrice(
                            @SerializedName("amount")
                            val amount: Int,
                            @SerializedName("currency_code")
                            val currencyCode: String,
                            @SerializedName("formatted_amount")
                            val formattedAmount: String
                        )

                        class UnitPrice(
                            @SerializedName("amount")
                            val amount: Int,
                            @SerializedName("currency_code")
                            val currencyCode: String,
                            @SerializedName("formatted_amount")
                            val formattedAmount: String
                        )
                    }
                }
            }
        }
    }

    class Eater(
        @SerializedName("delivery")
        val delivery: Delivery,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("nif_tax_id")
        val nifTaxId: NifTaxId,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("phone_code")
        val phoneCode: String
    ) {
        class NifTaxId(
            @SerializedName("key")
            val nifKey: String,
            @SerializedName("ciphertext")
            val nifCipherText: String
        )

        class Delivery(
            @SerializedName("location")
            val location: Location,
            @SerializedName("notes")
            val notes: String,
            @SerializedName("type")
            val type: String
        ) {

            class Location(
                @SerializedName("google_place_id")
                val googlePlaceId: String,
                @SerializedName("type")
                val type: String,
                @SerializedName("unit_number")
                val unitNumber: String
            )
        }
    }

    class Eaters(
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("id")
        val id: String
    )

    class Packaging(
        @SerializedName("disposable_items")
        val disposableItems: DisposableItems
    ) {
        class DisposableItems(
            @SerializedName("should_include")
            val shouldInclude: Boolean
        )
    }

    class Payment(
        @SerializedName("charges")
        val charges: Charges,
        @SerializedName("promotions")
        val promotions: Promotions
    ) {
        class Charges(
            @SerializedName("delivery_fee")
            val deliveryFee: DeliveryFee,
            @SerializedName("sub_total")
            val subTotal: SubTotal,
            @SerializedName("total")
            val total: Total,
            @SerializedName("total_fee")
            val totalFee: TotalFee
        ) {
            class DeliveryFee(
                @SerializedName("amount")
                val amount: Int,
                @SerializedName("currency_code")
                val currencyCode: String,
                @SerializedName("formatted_amount")
                val formattedAmount: String
            )

            class SubTotal(
                @SerializedName("amount")
                val amount: Int,
                @SerializedName("currency_code")
                val currencyCode: String,
                @SerializedName("formatted_amount")
                val formattedAmount: String
            )

            class Total(
                @SerializedName("amount")
                val amount: Int,
                @SerializedName("currency_code")
                val currencyCode: String,
                @SerializedName("formatted_amount")
                val formattedAmount: String
            )

            class TotalFee(
                @SerializedName("amount")
                val amount: Int,
                @SerializedName("currency_code")
                val currencyCode: String,
                @SerializedName("formatted_amount")
                val formattedAmount: String
            )
        }

        class Promotions(
            @SerializedName("promotions")
            val promotions: List<Promotion>
        ) {
            class Promotion(
                @SerializedName("discount_items")
                val discountItems: List<DiscountItem>,
                @SerializedName("external_promotion_id")
                val externalPromotionId: String,
                @SerializedName("promo_discount_percentage")
                val promoDiscountPercentage: Int,
                @SerializedName("promo_discount_value")
                val promoDiscountValue: Int,
                @SerializedName("promo_type")
                val promoType: String
            ) {
                class DiscountItem(
                    @SerializedName("discounted_quantity")
                    val discountedQuantity: Int,
                    @SerializedName("external_id")
                    val externalId: String
                )
            }
        }
    }

    class Store(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    )
}